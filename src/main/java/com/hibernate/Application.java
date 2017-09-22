package com.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  /* equivalent to @Configuration @EnableAutoConfiguration @ComponentScan */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
