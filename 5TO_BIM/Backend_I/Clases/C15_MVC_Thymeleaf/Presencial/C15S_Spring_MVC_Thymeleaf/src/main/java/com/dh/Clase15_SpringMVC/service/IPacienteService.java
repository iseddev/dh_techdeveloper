package com.dh.Clase15_SpringMVC.service;

import com.dh.Clase15_SpringMVC.model.Paciente;

import java.util.List;

public interface IPacienteService {

  Paciente guardar (Paciente paciente);

  Paciente buscarPorId(Integer id);

  void eliminar(Integer id);

  void actualizar (Paciente paciente);

  List<Paciente> listarTodos();
}