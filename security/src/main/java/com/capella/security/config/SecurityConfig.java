package com.capella.security.config;

import com.capella.security.filter.CustomAuthenticationFilter;
import com.capella.security.filter.CustomAuthorizationFilter;
import com.capella.service.model.ModelService;
import com.capella.service.user.UserService;
import com.capella.service.userrole.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Qualifier("erpUserService")
    protected final UserDetailsService userDetailsService;
    protected final ModelService modelService;
    protected final UserService userService;
    protected final UserRoleService userRoleService;
    protected final AuthenticationConfiguration authenticationConfiguration;
    @Value("${authentication.secret.key}")
    private String secretKey;
    @Value("${authentication.secret.accessTokenExpire}")
    private int accessTokenExpire;
    @Value("${authentication.secret.refreshTokenExpire}")
    private int refreshTokenExpire;
    @Value("${authentication.secret.issuer}")
    private String issuer;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .authenticationProvider(authenticationProvider())
                .formLogin().disable()
                .authenticationProvider(authenticationProvider())
                .addFilter(CustomAuthenticationFilter.builder().secretKey(secretKey)
                        .accessTokenExpire(accessTokenExpire)
                        .refreshTokenExpire(refreshTokenExpire)
                        .issuer(issuer)
                        .userService(userService)
                        .modelService(modelService)
                        .authenticationManager(authenticationManager(authenticationConfiguration))
                        .build())
                .addFilterBefore(CustomAuthorizationFilter.builder().secretKey(secretKey)
                        .userRoleService(userRoleService)
                        .build(), UsernamePasswordAuthenticationFilter.class);
        return  http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
