package com.banckend1.ReservaTurnos.service;

import com.dh.C20S_InyeccionDependencias.model.Turno;

import java.util.List;

public interface ITurnoService {
    //CRUD
    Turno guardar(Turno turno);
    Turno buscarPorId(Integer id);
    List<Turno> listarTodos();
}
