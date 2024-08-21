package com.example.paciente.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class HolaPacienteController {

    @GetMapping("/hola")
    public String pacienteHola() { return "<h1>Hola paciente!!!</h1>"; }

    @GetMapping("/adios")
    public String pacienteAdios() {
        System.out.println("ADIOS!!!");
        return "<h1>Adios paciente!!!</h1>";
    }

    public String response = pacienteHola();
}