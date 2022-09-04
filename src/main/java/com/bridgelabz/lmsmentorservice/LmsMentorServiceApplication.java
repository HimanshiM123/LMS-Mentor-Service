package com.bridgelabz.lmsmentorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LmsMentorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LmsMentorServiceApplication.class, args);
    }

}
