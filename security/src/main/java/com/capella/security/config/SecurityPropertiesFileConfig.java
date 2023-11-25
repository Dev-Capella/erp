package com.capella.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:security-${spring.profiles.active}.properties")
public class SecurityPropertiesFileConfig {
}
