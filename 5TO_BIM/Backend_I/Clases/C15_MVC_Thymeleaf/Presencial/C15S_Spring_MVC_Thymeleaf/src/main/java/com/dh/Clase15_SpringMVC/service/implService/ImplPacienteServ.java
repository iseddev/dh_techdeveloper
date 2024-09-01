package com.dh.Clase15_SpringMVC.service.implService;

import com.dh.Clase15_SpringMVC.dao.IDao;
import com.dh.Clase15_SpringMVC.dao.implDao.ImplPacienteH2;
import com.dh.Clase15_SpringMVC.model.Paciente;
import com.dh.Clase15_SpringMVC.service.IPacienteService;

import java.util.List;

public class ImplPacienteServ implements IPacienteService {

  private final IDao<Paciente> pacienteIDao;

  public ImplPacienteServ() {
    this.pacienteIDao = new ImplPacienteH2();
  }

  @Override
  public Paciente guardar(Paciente paciente) { return this.pacienteIDao.guardar(paciente); }

  @Override
  public Paciente buscarPorId(Integer id) { return pacienteIDao.consultarPorId(id); }

  @Override
  public void eliminar(Integer id) { this.pacienteIDao.eliminarPorId(id); }

  @Override
  public void actualizar(Paciente paciente) { this.pacienteIDao.actualizar(paciente); }

  @Override
  public List<Paciente> listarTodos() { return pacienteIDao.listarTodos(); }
}