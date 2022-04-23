package com.enigma.learnspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication//mengscan semua bean yang ada di aplikasi ini
@EnableWebMvc
public class LearnSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringbootApplication.class, args);
    }

}
