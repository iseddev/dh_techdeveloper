package com.banckend1.ReservaTurnos.service;

import com.banckend1.ReservaTurnos.model.Paciente;

import java.util.List;

public interface IPacienteService {

  Paciente insertPaciente(Paciente paciente);
  Paciente selectPaciente(Integer id);
  List<Paciente> selectAll();
  void updatePaciente(Paciente paciente);
  void deletePaciente(Integer id);

}