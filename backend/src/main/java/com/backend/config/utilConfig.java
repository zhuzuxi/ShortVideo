package com.backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class utilConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
