package com.example.C14S_SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dh_spring")
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        return("<h1>Hellow World!!!</h1>");
    }

    @GetMapping("/goodbye")
    public String goodbyeWorld() {
        return("<h1>Goodbye World!!!</h1>");
    }
}