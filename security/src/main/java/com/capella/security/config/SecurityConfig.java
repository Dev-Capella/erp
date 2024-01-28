package com.capella.security.config;

import com.capella.security.filter.CustomAuthenticationFilter;
import com.capella.security.filter.CustomAuthorizationFilter;
import com.capella.service.model.ModelService;
import com.capella.service.user.UserService;
import com.capella.service.userrole.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
@RequiredArgsConstructor
public class SecurityConfig {

    protected final UserDetailsService userDetailsService;
    protected final ModelService modelService;
    protected final UserService userService;
    protected final UserRoleService userRoleService;
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
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin().disable()
                .addFilter(CustomAuthenticationFilter.builder().secretKey(secretKey)
                        .accessTokenExpire(accessTokenExpire)
                        .refreshTokenExpire(refreshTokenExpire)
                        .issuer(issuer)
                        .userService(userService)
                        .modelService(modelService)
                        .build())
                .addFilterBefore(CustomAuthorizationFilter.builder().secretKey(secretKey)
                        .userRoleService(userRoleService)
                        .build(), UsernamePasswordAuthenticationFilter.class);
        return  http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/login");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

}
