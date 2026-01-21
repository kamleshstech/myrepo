package com.practice.resilience.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigCLS {

    @Bean
    RestTemplate getRestTemp() {

        return new RestTemplate();
    }
}
