package com.banckend1.ReservaTurnos.service;

import com.banckend1.ReservaTurnos.model.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente guardar (Paciente paciente);
    Paciente buscarPorId(Integer id);
    void eliminar(Integer id);
    void actualizar (Paciente paciente);
    List<Paciente> listarTodos();
}
