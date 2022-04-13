package com.enigma.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//mengscan semua bean yang ada di aplikasi ini
public class LearnSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringbootApplication.class, args);
    }

}
