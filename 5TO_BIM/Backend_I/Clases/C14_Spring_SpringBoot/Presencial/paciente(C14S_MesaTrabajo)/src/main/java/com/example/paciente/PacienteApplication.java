package com.example.paciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PacienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteApplication.class, args);
	}

//	@GetMapping("/paciente/hola")
//	public String holaPaciente() {
//		return "<h1>Hola paciente!!!</h1>";
//	}
//
//	@GetMapping("/paciente/adios")
//	public String adiosPaciente() {
//		return "<h1>Adios paciente!!!</h1>";
//	}
}