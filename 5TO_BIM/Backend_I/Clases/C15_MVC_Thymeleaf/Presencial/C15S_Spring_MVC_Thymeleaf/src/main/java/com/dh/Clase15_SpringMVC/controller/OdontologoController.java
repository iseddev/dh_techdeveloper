package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.model.Odontologo;
import com.dh.Clase15_SpringMVC.service.IOdontologoService;
import com.dh.Clase15_SpringMVC.service.implService.ImplOdontologoServ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Controller -> THYMELEAF => Comunicación con la vista
// RestController -> API REST

// Esta anotación define a la Clase OdontologoController como un controladpr de Spring MVC
@Controller
// Ruta que se puede introducir en el navegador y que nos serivirá para asociar dicha URL a esta Clase
// /odontologos => OdontologoController{ ... }
@RequestMapping("/odontologos")
public class OdontologoController {

  // Instancia de la Interfaz necesaria que hará uso del servicio correspondiente
  private final IOdontologoService iOdontologoService;

  // Definimos a la instancia iOdontologoService la implementación correspondiente en el constructor
  public OdontologoController() { this.iOdontologoService = new ImplOdontologoServ(); }


  // Model model => Thymeleaf
  // @RequestParam => Mediante la url, se le pasa el id(Integer) que se requiere consultar
  // /odontologos/id?id=1
  @GetMapping("/id")
  public String buscarPorId(Model model, @RequestParam Integer id) {
    Odontologo odontologo = iOdontologoService.buscarPorId(id);
    model.addAttribute("nombre", odontologo.getNombre());
    model.addAttribute("apellido", odontologo.getApellido());

    // Retornamos el nombre de nuestro HTML
    return "buscarOdontologo";
  }
}