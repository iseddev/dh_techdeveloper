package com.example.C14S_SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Annotations => En este caso vamos a simular una APIRest

@RequestMapping("/dh_spring")

public class HelloWorldController {

  // HTTP Methods => GET, POST, PUT, DELETE, etc. Para este caso vamos a usar @GetMapping
  @GetMapping("/hello")
  public String helloWorld() { return("<h1>Petición GET realizada => Hellow World!!!</h1>"); }

  @GetMapping("/goodbye")
  public String goodbyeWorld() { return("<h1>Petición GET realizada => Goodbye World!!!</h1>"); }
}