package com.dh.Clase17S_APIRest_I.service.impl;

import com.dh.Clase17S_APIRest_I.dao.IDao;
import com.dh.Clase17S_APIRest_I.dao.impl.ImplPacienteH2;
import com.dh.Clase17S_APIRest_I.model.Paciente;
import com.dh.Clase17S_APIRest_I.service.IPacienteService;

import java.util.List;

public class ImplPacienteService implements IPacienteService {

    private IDao<Paciente> pacienteIDao;

    public ImplPacienteService() { this.pacienteIDao = new ImplPacienteH2(); }

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return pacienteIDao.consultarPorId(id);
    }

    @Override
    public List<Paciente> listarTodos() {
        return pacienteIDao.listarTodos();
    }

    @Override
    public void actualizar(Paciente paciente) {
        this.pacienteIDao.actualizar(paciente);
    }

    @Override
    public void eliminar(Integer id){
        this.pacienteIDao.eliminarPorId(id);
    }
}