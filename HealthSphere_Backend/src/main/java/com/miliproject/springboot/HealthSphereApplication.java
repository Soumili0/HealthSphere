package com.miliproject.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.miliproject.springboot")
public class HealthSphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthSphereApplication.class, args);
    }

}
