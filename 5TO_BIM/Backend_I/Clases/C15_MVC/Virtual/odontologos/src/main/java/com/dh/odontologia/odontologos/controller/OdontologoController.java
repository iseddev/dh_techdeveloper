package com.dh.odontologia.odontologos.controller;

import com.dh.odontologia.odontologos.model.Odontologo;
import com.dh.odontologia.odontologos.service.IOdontologoService;
import com.dh.odontologia.odontologos.service.implementation.ImplOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/odontologos")
public class OdontologoController {
  private final IOdontologoService odontologoService;

  @Autowired
  public OdontologoController() { this.odontologoService = new ImplOdontologoService(); }

  @GetMapping("/lista")
  public List<Odontologo> getOdontologos() { return odontologoService.listaOdontologos(); }
}