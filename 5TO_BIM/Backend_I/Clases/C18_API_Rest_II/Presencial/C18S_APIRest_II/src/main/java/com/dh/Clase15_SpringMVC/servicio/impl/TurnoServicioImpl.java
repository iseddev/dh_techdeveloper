package com.dh.Clase15_SpringMVC.servicio.impl;

import com.dh.Clase15_SpringMVC.repository.IDAO;
import com.dh.Clase15_SpringMVC.repository.impl.ImplementacionTurnoList;
import com.dh.Clase15_SpringMVC.modelo.Turno;
import com.dh.Clase15_SpringMVC.servicio.ITurnoServicio;

import java.util.List;

public class TurnoServicioImpl implements ITurnoServicio {

  private final IDAO<Turno> iDao;

  public TurnoServicioImpl () {
    this.iDao = new ImplementacionTurnoList();
  }

  @Override
  public Turno guardar(Turno turno) {
    return iDao.guardar(turno);
  }

  @Override
  public Turno buscarPorId(Integer id) {
    return iDao.consultarPorId(id);
  }

  @Override
  public List<Turno> listarTodos() {
    return iDao.listarTodos();
  }
}