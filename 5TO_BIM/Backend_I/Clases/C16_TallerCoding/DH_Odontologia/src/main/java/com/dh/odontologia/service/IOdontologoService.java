package com.dh.odontologia.service;

import com.dh.odontologia.model.Odontologo;

import java.util.List;

public interface IOdontologoService {

  Odontologo guardar (Odontologo odontologo);
  Odontologo buscarPorId(Integer id);
  void eliminar(Integer id);
  void actualizar (Odontologo odontologo);
  List<Odontologo> listarTodos();
}
