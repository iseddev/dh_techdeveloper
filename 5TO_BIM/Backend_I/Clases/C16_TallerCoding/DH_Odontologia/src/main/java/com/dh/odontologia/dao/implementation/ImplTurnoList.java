package com.dh.odontologia.dao.implementation;

import com.dh.odontologia.dao.IDao;
import com.dh.odontologia.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class ImplTurnoList implements IDao<Turno> {

  List<Turno> turnsList = new ArrayList<>();

  @Override
  public Turno insertRecord(Turno turno) {
    // id lo vamos a cargar a mano
    turnsList.add(turno);
    return turno;
  }

  @Override
  public Turno getRecordById(Integer id) {
    Turno turnoBuscado = null;
    for (Turno t: turnsList) { if(t.getId().equals(id)) { return t; } }
    return turnoBuscado;
  }

  @Override
  public List<Turno> getAllRecords() {
    return turnsList;
  }

  @Override
  public void deleteRecordById(Integer id) {}

  @Override
  public void updateRecord(Turno turno) {}
}
