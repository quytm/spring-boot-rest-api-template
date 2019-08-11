package com.tmq.food4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Food4uApplication {

    public static void main(String[] args) {
        SpringApplication.run(Food4uApplication.class, args);
    }

}
