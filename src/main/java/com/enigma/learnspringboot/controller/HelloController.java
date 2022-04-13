package com.enigma.learnspringboot.controller;

import com.enigma.learnspringboot.entity.Hello;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class HelloController {
    @RequestMapping("/hello")//ini merupakan method html seperti post put dll
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String hellow(@PathVariable String name) {
        return "Hello new User ^o^ " + name;
    }

    @GetMapping("/helloo")
    //http://localhost:8080/hello?name=dika
    public String hello2(@RequestParam String name) {
        return "Hello new User ^o^ " + name;
    }

//    @PostMapping("/user")
//    public String reqBody(@RequestBody HashMap<String, String> user){//inoutan berupa form
//        return "username : " + user;
//    }
    @PostMapping("/user")
    public Hello reqBody(@RequestBody Hello user){//inoutan berupa form
        return user;
    }

}
