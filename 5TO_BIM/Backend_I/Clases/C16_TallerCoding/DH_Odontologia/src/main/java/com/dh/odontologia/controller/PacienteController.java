package com.dh.odontologia.controller;

import com.dh.odontologia.model.Paciente;
import com.dh.odontologia.service.IPacienteService;
import com.dh.odontologia.service.implService.ImplPacienteServ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Controller -> THYMELEAF => Comunicación con la vista
// RestController -> API REST

// Esta anotación define a la Clase PacienteController como un controladpr de Spring MVC
@Controller
// Ruta que se puede introducir en el navegador y que nos serivirá para asociar dicha URL a esta Clase
// /pacientes => PacienteController{ ... }
@RequestMapping("/pacientes")
public class PacienteController {

  // Instancia de la Interfaz necesaria que hará uso del servicio correspondiente
  private final IPacienteService iPacienteService;

  // Definimos a la instancia iPacienteService la implementación correspondiente en el constructor
  public PacienteController() { this.iPacienteService = new ImplPacienteServ(); }

  // Model model => Thymeleaf
  // @RequestParam => Mediante la url, se le pasa el id(Integer) que se requiere consultar
  // /pacientes/id?id=1
  @GetMapping("/id")
  public String buscarPorId(Model model, @RequestParam Integer id) {
    Paciente paciente = iPacienteService.getPatientById(id);
    model.addAttribute("nombre", paciente.getNombre());
    model.addAttribute("apellido", paciente.getApellido());

    // Retornamos el nombre de nuestro HTML
    return "buscarPaciente";
  }
}