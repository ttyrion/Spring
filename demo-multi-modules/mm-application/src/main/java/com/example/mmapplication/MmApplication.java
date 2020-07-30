package com.example.mmapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MmApplication {
    public static void main(String[] args) {
        System.out.println("service is starting...");
        SpringApplication.run(MmApplication.class, args);
    }
}
