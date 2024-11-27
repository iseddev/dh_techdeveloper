package com.dh.odontologia.service;

import com.dh.odontologia.model.Turno;
import java.util.List;

public interface ITurnoService {

  // CRUD
  Turno insertTurn(Turno turno);
  Turno getTurnById(Integer id);
  List<Turno> getTurnsList();

}