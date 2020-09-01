package com.example.mmapplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import com.example.mmapplication.conditions.RunnerCondition;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
@EnableAsync
public class MmApplication {
    public static void main(String[] args) {
        System.out.println("service is starting...");
        SpringApplication.run(MmApplication.class, args);
    }

    @Bean
    @Conditional(RunnerCondition.class)
    public ApplicationRunner runner(WebServerApplicationContext context) {
        return args -> {
            System.out.println("*************");
            System.out.println("Current Web Server is :"
                    + context.getWebServer().getClass().getName());
            System.out.println("*************");
        };
    }
}

