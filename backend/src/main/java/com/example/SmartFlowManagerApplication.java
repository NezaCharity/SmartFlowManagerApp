package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.servlets") // Scans for servlets
@ComponentScan(basePackages = {
    "com.example.config",
    "com.example.controllers",
    "com.example.services",
    "com.example.repositories",
    "com.example.utils",
    "com.example.models"
})

public class SmartFlowManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartFlowManagerApplication.class, args);
    }
}
