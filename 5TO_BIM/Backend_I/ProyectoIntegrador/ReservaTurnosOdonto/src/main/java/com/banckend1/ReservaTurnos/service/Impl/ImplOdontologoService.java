package com.banckend1.ReservaTurnos.service.Impl;

import com.banckend1.ReservaTurnos.dao.IOdontologoDAO;
import com.banckend1.ReservaTurnos.model.Odontologo;
import com.banckend1.ReservaTurnos.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImplOdontologoService implements IOdontologoService {

    @Autowired
    private IOdontologoDAO odontoDAO;
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontoDAO.save(odontologo);
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return odontoDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        odontoDAO.deleteById(id);
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        odontoDAO.save(odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return odontoDAO.findAll();
    }
}
