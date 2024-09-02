package com.banckend1.ReservaTurnos.dao.Impl;

import com.banckend1.ReservaTurnos.dao.IDAO;
import com.banckend1.ReservaTurnos.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class ImplementacionTurno implements IDAO<Turno> {
    List<Turno> turnoList = new ArrayList<>();
    @Override
    public Turno guardar(Turno turno) {
        //id lo vamos a cargar a mano
        turnoList.add(turno);
        return turno;
    }

    @Override
    public List<Turno> listarTodos() {
        return turnoList;
    }

    @Override
    public Turno consultarPorId(Integer id) {
        Turno turnoBuscado = null;

        for (Turno t: turnoList) {
            if(t.getId().equals(id)) {

                return t;
            }
        }
        return turnoBuscado;
    }

    @Override
    public void eliminarPorId(Integer id) {
        Turno turno = this.consultarPorId(id);
        turnoList.remove(turno);
    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }
}
