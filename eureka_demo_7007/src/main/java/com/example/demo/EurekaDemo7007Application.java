package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaDemo7007Application {
    
    public static void main(String[] args) {
        SpringApplication.run(EurekaDemo7007Application.class, args);
    }
    
}
