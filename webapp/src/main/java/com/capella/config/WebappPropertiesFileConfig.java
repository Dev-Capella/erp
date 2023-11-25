package com.capella.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:webapp-${spring.profiles.active}.properties")
public class WebappPropertiesFileConfig {
}
