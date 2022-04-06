package com.thalerngsak.apitest.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean
    public RestTemplate randomUserAdapterRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}
