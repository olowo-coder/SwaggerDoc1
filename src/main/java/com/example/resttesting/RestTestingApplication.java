package com.example.resttesting;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User API ", version = "3.1.0.4",
        description = "for testing swagger and displaying Information " ))
public class RestTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTestingApplication.class, args);
    }

}
