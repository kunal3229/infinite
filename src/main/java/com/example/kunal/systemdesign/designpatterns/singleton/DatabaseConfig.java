package com.example.kunal.systemdesign.designpatterns.singleton;

import org.springframework.stereotype.Service;

// Traditional Singleton (Don't use in Spring Boot)

@Service
public class DatabaseConfig {

    private static DatabaseConfig instance;
    private String dbUrl;

    DatabaseConfig() {
        dbUrl = "jdbc:mysql://localhost:3306/";
    }

    public static DatabaseConfig getInstance() {
        if (instance == null){
            synchronized (DatabaseConfig.class){
                if (instance == null){
                    instance = new DatabaseConfig();
                }
            }
        }
        return instance;
    }
}
