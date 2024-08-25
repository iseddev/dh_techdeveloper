package com.dh.odontologia.odontologos.service.implementation;

import com.dh.odontologia.odontologos.model.Odontologo;
import com.dh.odontologia.odontologos.service.IOdontologoService;

import java.util.Arrays;
import java.util.List;

public class ImplOdontologoService implements IOdontologoService {

  @Override
  public List<Odontologo> listaOdontologos() {
    return Arrays.asList(new Odontologo("Javier"), new Odontologo("Ramon"));
  }
}
