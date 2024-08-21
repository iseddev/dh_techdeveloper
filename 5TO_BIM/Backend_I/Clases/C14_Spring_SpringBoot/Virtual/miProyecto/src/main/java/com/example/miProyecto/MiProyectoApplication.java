package com.example.miProyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MiProyectoApplication {

	public static void main(String[] args) { SpringApplication.run(MiProyectoApplication.class, args); }

	@GetMapping
	public String holaMundo() { return "<h1>Hola Mundo</h1>"; }
}