package com.dh.Clase17S_APIRest_I.service;

import com.dh.Clase17S_APIRest_I.model.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo guardar (Odontologo odontologo);
    Odontologo buscarPorId(Integer id);
    List<Odontologo> listarTodos();
    void actualizar (Odontologo odontologo);
    void eliminar(Integer id);
}
