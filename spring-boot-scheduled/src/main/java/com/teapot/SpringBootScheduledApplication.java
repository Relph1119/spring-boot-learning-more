package com.teapot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 放开Scheduled定时任务
public class SpringBootScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootScheduledApplication.class, args);
    }

}
