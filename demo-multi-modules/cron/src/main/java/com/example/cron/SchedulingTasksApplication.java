package com.example.cron;

/**
 * @Description:
 * @Date: Created on 14:31 2020/8/28
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.example")
public class SchedulingTasksApplication {

    public static void main(String[] args) {
        System.out.println("Service Starting...");
        SpringApplication.run(SchedulingTasksApplication.class);
    }
}