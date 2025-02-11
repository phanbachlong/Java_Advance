package com.vti.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentConfiguration {

    @Bean
    ModelMapper innitModelMapper() {
        return new ModelMapper();
    }
}
