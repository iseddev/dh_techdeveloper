package com.dh.odontologia.service.implService;

import com.dh.odontologia.dao.IDao;
import com.dh.odontologia.dao.implementation.ImplTurnoList;
import com.dh.odontologia.model.Turno;
import com.dh.odontologia.service.ITurnoService;

import java.util.List;

public class ImplTurnoService implements ITurnoService {

  private final IDao<Turno> turnoIDao;

  public ImplTurnoService() { turnoIDao = new ImplTurnoList(); }

  @Override
  public Turno insertTurn(Turno turno) { return turnoIDao.insertRecord(turno); }

  @Override
  public Turno getTurnById(Integer id) { return turnoIDao.getRecordById(id); }

  @Override
  public List<Turno> getTurnsList() { return turnoIDao.getAllRecords(); }
}