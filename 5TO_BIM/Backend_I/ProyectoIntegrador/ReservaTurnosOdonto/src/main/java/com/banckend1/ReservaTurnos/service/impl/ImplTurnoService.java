package com.banckend1.ReservaTurnos.service.impl;

import com.banckend1.ReservaTurnos.repository.IDAO;
import com.banckend1.ReservaTurnos.model.Turno;
import com.banckend1.ReservaTurnos.service.ITurnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplTurnoService implements ITurnoService {

  private IDAO<Turno> turnoIDAO;
  public ImplTurnoService(IDAO<Turno> turnoIDAO) { this.turnoIDAO = turnoIDAO; }


  @Override
  public Turno insertTurno(Turno turno) { return turnoIDAO.insertRecord(turno); }

  @Override
  public Turno selectTurno(Integer id) {
    return turnoIDAO.getRecord(id);
  }

  @Override
  public List<Turno> selectAll() {
    return turnoIDAO.getAllRecords();
  }
}