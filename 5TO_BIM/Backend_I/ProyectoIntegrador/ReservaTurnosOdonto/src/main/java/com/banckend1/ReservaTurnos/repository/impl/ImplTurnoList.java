package com.banckend1.ReservaTurnos.repository.impl;

import com.banckend1.ReservaTurnos.repository.IDAO;
import com.banckend1.ReservaTurnos.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class ImplTurnoList implements IDAO<Turno> {

  List<Turno> turnoList = new ArrayList<>();


  // ############################## CREATE(INSERT) A Turno ##############################
  @Override
  public Turno insertRecord(Turno turno) {
    // id lo vamos a cargar a mano
    turnoList.add(turno);
    return turno;
  }


  // ############################## READ(GET) A Turno BY ID ##############################
  @Override
  public Turno getRecord(Integer id) {

    Turno turnoBuscado = null;

    for (Turno turno: turnoList) { if(turno.getId().equals(id)) { return turno; } }
    return turnoBuscado;
  }


  // ############################## READ(GET) ALL Turnos ##############################
  @Override
  public List<Turno> getAllRecords() { return turnoList; }


  // ############################## UPDATE A Turno ##############################
  @Override
  public void updateRecord(Turno turno) {
    // TODO
  }


  // ############################## DELETE A Turno ##############################
  @Override
  public void deleteRecord(Integer id) {
    Turno turno = this.getRecord(id);
    turnoList.remove(turno);
  }
}
