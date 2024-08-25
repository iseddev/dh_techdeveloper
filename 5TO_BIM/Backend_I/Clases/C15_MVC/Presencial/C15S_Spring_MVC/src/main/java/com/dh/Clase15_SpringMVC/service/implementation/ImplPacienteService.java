package com.dh.Clase15_SpringMVC.service.implementation;

import com.dh.Clase15_SpringMVC.dao.IDao;
import com.dh.Clase15_SpringMVC.dao.implementation.ImplPacienteDaoH2;
import com.dh.Clase15_SpringMVC.model.Paciente;
import com.dh.Clase15_SpringMVC.service.IPacienteService;

import java.util.List;

public class ImplPacienteService implements IPacienteService {

  private final IDao<Paciente> pacienteIDao;

  public ImplPacienteService() {
    this.pacienteIDao = new ImplPacienteDaoH2();
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