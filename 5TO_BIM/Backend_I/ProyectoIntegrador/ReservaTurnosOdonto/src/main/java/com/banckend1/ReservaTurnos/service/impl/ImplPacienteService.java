package com.banckend1.ReservaTurnos.service.impl;

import com.banckend1.ReservaTurnos.repository.IPacienteDAO;
import com.banckend1.ReservaTurnos.model.Paciente;
import com.banckend1.ReservaTurnos.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplPacienteService implements IPacienteService {

  @Autowired
  private IPacienteDAO iPacienteDAO;

  @Override
  public Paciente insertPaciente(Paciente paciente) {
    return iPacienteDAO.save(paciente);
  }

  @Override
  public Paciente selectPaciente(Integer id) {
    return iPacienteDAO.findById(id).orElse(null);
  }

  @Override
  public void deletePaciente(Integer id) {
    iPacienteDAO.deleteById(id);
  }

  @Override
  public void updatePaciente(Paciente paciente) {
    iPacienteDAO.save(paciente);
  }

  @Override
  public List<Paciente> selectAll() {
    return iPacienteDAO.findAll();
  }
}