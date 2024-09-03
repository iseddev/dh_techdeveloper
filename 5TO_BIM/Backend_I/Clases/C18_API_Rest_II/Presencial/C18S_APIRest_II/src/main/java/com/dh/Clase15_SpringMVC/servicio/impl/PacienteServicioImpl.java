package com.dh.Clase15_SpringMVC.servicio.impl;

import com.dh.Clase15_SpringMVC.repository.IDAO;
import com.dh.Clase15_SpringMVC.repository.impl.ImplementacionPaciente;
import com.dh.Clase15_SpringMVC.modelo.Paciente;
import com.dh.Clase15_SpringMVC.servicio.IPacienteServicio;

import java.util.List;

public class PacienteServicioImpl implements IPacienteServicio {

  private final IDAO<Paciente> interfazDAO;

  public PacienteServicioImpl() {
    this.interfazDAO = new ImplementacionPaciente();
  }

  @Override
  public Paciente guardar(Paciente paciente) { return this.interfazDAO.guardar(paciente); }

  @Override
  public Paciente buscarPorId(Integer id) {
    return this.interfazDAO.consultarPorId(id);
  }

  @Override
  public List<Paciente> listarTodos() {
    return this.interfazDAO.listarTodos();
  }

  @Override
  public void actualizar(Paciente paciente) { this.interfazDAO.actualizar(paciente); }

  @Override
  public void eliminar(Integer id) { this.interfazDAO.eliminarPorId(id); }
}