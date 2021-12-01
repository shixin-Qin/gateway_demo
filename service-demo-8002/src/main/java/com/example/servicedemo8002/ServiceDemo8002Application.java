package com.example.servicedemo8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceDemo8002Application {
    
    public static void main(String[] args) {
        SpringApplication.run(ServiceDemo8002Application.class, args);
    }
    
}
