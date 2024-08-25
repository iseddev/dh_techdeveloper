package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.model.Paciente;
import com.dh.Clase15_SpringMVC.service.IPacienteService;
import com.dh.Clase15_SpringMVC.service.implementation.ImplPacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
  // Instancia de la Interfaz necesaria
  private final IPacienteService iPacienteService;
  // Definimos a la instancia iPacienteService la implementación correspondiente
  public PacienteController() { this.iPacienteService = new ImplPacienteService(); }

  // Model model => Thymeleaf
  // @RequestParam => Mediante la url, se le pasa el id(Integer) que se requiere consultar
  @GetMapping("/id")
  public String buscarPorId(Model model, @RequestParam Integer id) {
    Paciente paciente = iPacienteService.buscarPorId(id);
    model.addAttribute("nombre", paciente.getNombre());
    model.addAttribute("apellido", paciente.getApellido());

    // Retornamos el nombre de nuestro HTML
    return "buscarPaciente";
  }
}