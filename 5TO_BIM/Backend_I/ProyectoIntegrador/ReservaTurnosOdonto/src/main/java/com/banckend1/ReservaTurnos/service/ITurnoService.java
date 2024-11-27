package com.banckend1.ReservaTurnos.service;

import com.banckend1.ReservaTurnos.model.Turno;

import java.util.List;

public interface ITurnoService {

  Turno insertTurno(Turno turno);
  Turno selectTurno(Integer id);
  List<Turno> selectAll();

}