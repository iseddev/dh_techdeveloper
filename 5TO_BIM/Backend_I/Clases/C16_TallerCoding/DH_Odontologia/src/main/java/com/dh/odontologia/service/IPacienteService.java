package com.dh.odontologia.service;

import com.dh.odontologia.model.Paciente;

import java.util.List;

public interface IPacienteService {

  Paciente guardar (Paciente paciente);
  Paciente buscarPorId(Integer id);
  void eliminar(Integer id);
  void actualizar (Paciente paciente);
  List<Paciente> listarTodos();
}