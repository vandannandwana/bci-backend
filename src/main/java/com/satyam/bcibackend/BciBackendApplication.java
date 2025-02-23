package com.satyam.bcibackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.satyam.bcibackend.repositories")
public class BciBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BciBackendApplication.class, args);
    }
}
