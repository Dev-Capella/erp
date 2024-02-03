package com.capella.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.capella.domain.data.login.LoginRequestData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.LoginResultType;
import com.capella.domain.enums.ProcessStatus;
import com.capella.domain.model.useraudit.UserAuditModel;
import com.capella.security.domain.AuthToken;
import com.capella.service.model.ModelService;
import com.capella.service.user.UserService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@AllArgsConstructor
@Builder
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final String LOGIN_REQUEST = "loginRequest";
    private static final String SYSTEM = "SYSTEM";

    private final AuthenticationManager authenticationManager;
    protected final UserService userService;
    protected final ModelService modelService;

    protected final String secretKey;
    protected final String issuer;
    protected final int accessTokenExpire;
    protected final int refreshTokenExpire;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals(HttpMethod.POST.name())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        LoginRequestData loginRequest;
        if (APPLICATION_JSON_VALUE.equals(request.getHeader(HttpHeaders.CONTENT_TYPE))) {
            loginRequest = this.getLoginRequest(request);
        } else {
            loginRequest = new LoginRequestData();
            loginRequest.setUsername(super.obtainUsername(request));
            loginRequest.setPassword(super.obtainPassword(request));
        }
        request.setAttribute(LOGIN_REQUEST, loginRequest);
        var authentication = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        setDetails(request, authentication);

        return authenticationManager.authenticate(authentication);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        var ip = request.getHeader("x-real-ip");
        var clientInfo = request.getHeader("User-Agent");
        var user = (User) authResult.getPrincipal();
        var algorithm = Algorithm.HMAC256(secretKey.getBytes());
        var jwtId = UUID.randomUUID().toString();

        var userModel = userService.getUserModel(user.getUsername());

        var accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withClaim("firstName", userModel.getFirstName())
                .withClaim("lastName", userModel.getLastName())
                .withExpiresAt(DateUtils.addMinutes(new Date(), accessTokenExpire))
                .withIssuer(issuer)
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .withJWTId(jwtId)
                .sign(algorithm);

        var refreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(DateUtils.addMinutes(new Date(), refreshTokenExpire))
                .withIssuer(issuer)
                .withJWTId(jwtId)
                .sign(algorithm);



        if (Objects.nonNull(userModel)) {
            userModel.setLastLoginDate(new Date());
            modelService.save(userModel);
        }

        new ObjectMapper().writeValue(response.getOutputStream(),
                AuthToken.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken).build());

        UserAuditModel userAuditModel = new UserAuditModel();
        userAuditModel.setCode(UUID.randomUUID().toString());
        userAuditModel.setUser(userModel);
        userAuditModel.setLoginDate(new Date());
        userAuditModel.setLoginResultType(LoginResultType.SUCCESSFULL);
        userAuditModel.setIp(ip);
        userAuditModel.setClientInfo(clientInfo);
        userAuditModel.setCreatedDate(new Date());
        userAuditModel.setCreatedBy(SYSTEM);
        userAuditModel.setLastModifiedBy(SYSTEM);
        modelService.save(userAuditModel);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        var loginRequest = (LoginRequestData) request.getAttribute(LOGIN_REQUEST);
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        var serviceResponseData = new ServiceResponseData();
        serviceResponseData.setStatus(ProcessStatus.ERROR);
        serviceResponseData.setErrorMessage("Kullanıcı adınız ve şifreniz hatalıdır");
        var mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.writeValue(response.getOutputStream(), serviceResponseData);
        var ip = request.getHeader("x-real-ip");
        var clientInfo = request.getHeader("User-Agent");
        var username = loginRequest.getUsername();
        try {
            var userModel = userService.getUserModel(username);
            UserAuditModel userAuditModel = new UserAuditModel();
            userAuditModel.setCode(UUID.randomUUID().toString());
            userAuditModel.setUser(userModel);
            userAuditModel.setLoginDate(new Date());
            userAuditModel.setLoginResultType(LoginResultType.UNSUCCESSFULL);
            userAuditModel.setIp(ip);
            userAuditModel.setClientInfo(clientInfo);
            userAuditModel.setCreatedDate(new Date());
            userAuditModel.setCreatedBy(SYSTEM);
            userAuditModel.setLastModifiedBy(SYSTEM);
            modelService.save(userAuditModel);
        } catch (Exception exception) {
            log.error("userAudit saving error with username" + username);
        }
    }

    private LoginRequestData getLoginRequest(HttpServletRequest request) {
        LoginRequestData loginRequest = new LoginRequestData();

        try (BufferedReader bufferedReader = request.getReader()) {
            if (bufferedReader != null) {
                loginRequest = new ObjectMapper().readValue(bufferedReader, LoginRequestData.class);
            } else {
                log.error("BufferedReader is null");
            }
        } catch (IOException exception) {
            log.error(exception.getLocalizedMessage());
        }

        return loginRequest;
    }
}
