package com.dh.Clase17S_APIRest_I.controller;


import com.dh.Clase17S_APIRest_I.model.Odontologo;
import com.dh.Clase17S_APIRest_I.service.IOdontologoService;
import com.dh.Clase17S_APIRest_I.service.impl.ImplOdontologoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Controller -> THYMELEAF
public class ThymeleafController {
    private IOdontologoService odontologoServicio;

    public ThymeleafController() {
        this.odontologoServicio = new ImplOdontologoService();
    }

    @GetMapping("/id")
    public String buscarOdontologoPorId(Model model, // Thymeleaf
                                        @RequestParam Integer id) {
        Odontologo odontologo = odontologoServicio.buscarPorId(id);
        model.addAttribute("nombre", odontologo.getNombre());
        model.addAttribute("apellido", odontologo.getApellido());
        return "buscarOdontologo";
    }
}