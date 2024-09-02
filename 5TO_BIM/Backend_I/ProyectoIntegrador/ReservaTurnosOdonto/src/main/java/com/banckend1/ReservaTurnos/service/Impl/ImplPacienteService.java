package com.banckend1.ReservaTurnos.service.Impl;

import com.banckend1.ReservaTurnos.dao.IPacienteDAO;
import com.banckend1.ReservaTurnos.model.Paciente;
import com.banckend1.ReservaTurnos.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImplPacienteService implements IPacienteService {

    @Autowired
    private IPacienteDAO pacienteDAO;
    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteDAO.save(paciente);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return pacienteDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        pacienteDAO.deleteById(id);
    }

    @Override
    public void actualizar(Paciente paciente) {
        pacienteDAO.save(paciente);
    }

    @Override
    public List<Paciente> listarTodos() {
        return pacienteDAO.findAll();
    }
}
