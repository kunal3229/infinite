package com.example.kunal.systemdesign.designpatterns.singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Spring Boot Way (Recommended) - Spring manages singletons

@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton")
    public DatabaseConfig databaseConfig() {
        return new DatabaseConfig();
    }

}

