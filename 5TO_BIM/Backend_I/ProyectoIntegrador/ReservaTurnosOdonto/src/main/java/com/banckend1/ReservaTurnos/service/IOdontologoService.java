package com.banckend1.ReservaTurnos.service;

import com.banckend1.ReservaTurnos.model.Odontologo;

import java.util.List;

public interface IOdontologoService {

  Odontologo insertOdontologo(Odontologo odontologo);
  Odontologo selectOdontologo(Integer id);
  List<Odontologo> selectAll();
  void updateOdontologo(Odontologo odontologo);
  void deleteOdontologo(Integer id);

}