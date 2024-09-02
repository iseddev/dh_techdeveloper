package com.dh.odontologia.service.implService;

import com.dh.odontologia.dao.IDao;
import com.dh.odontologia.dao.implDao.ImplPacienteH2;
import com.dh.odontologia.model.Paciente;
import com.dh.odontologia.service.IPacienteService;

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