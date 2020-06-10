package com.example.productactivemqdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductactivemqdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductactivemqdemoApplication.class, args);
    }

}
