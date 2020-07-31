package com.example.mmapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class MmApplication {
    public static void main(String[] args) {
        System.out.println("service is starting...");
        SpringApplication.run(MmApplication.class, args);
    }
}
