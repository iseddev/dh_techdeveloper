package com.banckend1.ReservaTurnos.service.Impl;

import com.banckend1.ReservaTurnos.dao.IPacienteDAO;
import com.banckend1.ReservaTurnos.model.Paciente;
import com.banckend1.ReservaTurnos.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImplPacienteService implements IPacienteService {

    @Autowired
    private IPacienteDAO iPacienteDAO;
    @Override
    public Paciente insertPaciente(Paciente paciente) {
        return iPacienteDAO.save(paciente);
    }

    @Override
    public Paciente selectPaciente(Integer id) {
        return iPacienteDAO.findById(id).orElse(null);
    }

    @Override
    public void deletePaciente(Integer id) {
        iPacienteDAO.deleteById(id);
    }

    @Override
    public void updatePaciente(Paciente paciente) {
        iPacienteDAO.save(paciente);
    }

    @Override
    public List<Paciente> selectAll() {
        return iPacienteDAO.findAll();
    }
}
