package com.dh.Clase15_SpringMVC.service;

import com.dh.Clase15_SpringMVC.model.Odontologo;

import java.util.List;

public interface IOdontologoService {

  Odontologo guardar (Odontologo odontologo);

  Odontologo buscarPorId(Integer id);

  void eliminar(Integer id);

  void actualizar (Odontologo odontologo);

  List<Odontologo> listarTodos();
}
