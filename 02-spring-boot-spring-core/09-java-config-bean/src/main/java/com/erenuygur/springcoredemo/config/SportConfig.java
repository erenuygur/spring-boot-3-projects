package com.erenuygur.springcoredemo.config;

import com.erenuygur.springcoredemo.common.Coach;
import com.erenuygur.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
