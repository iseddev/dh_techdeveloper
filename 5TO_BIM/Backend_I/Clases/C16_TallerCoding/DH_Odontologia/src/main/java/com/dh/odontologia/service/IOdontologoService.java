package com.dh.odontologia.service;

import com.dh.odontologia.model.Odontologo;

import java.util.List;

public interface IOdontologoService {

  Odontologo insertDentist(Odontologo odontologo);
  Odontologo getDentistById(Integer id);
  List<Odontologo> getDentistsList();
  void updateDentist(Odontologo odontologo);
  void deleteDentist(Integer id);

}