package com.dh.Clase17S_APIRest_I.service;

import com.dh.Clase17S_APIRest_I.model.Paciente;

import java.util.List;

public interface IPacienteService {

  Paciente guardar (Paciente paciente);
  Paciente buscarPorId(Integer id);
  List<Paciente> listarTodos();
  void actualizar (Paciente paciente);
  void eliminar(Integer id);
}