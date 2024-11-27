package com.dh.odontologia.service;

import com.dh.odontologia.model.Paciente;

import java.util.List;

public interface IPacienteService {

  Paciente insertPatient(Paciente paciente);
  Paciente getPatientById(Integer id);
  List<Paciente> getPatientsList();
  void updatePatient(Paciente paciente);
  void deletePatient(Integer id);

}