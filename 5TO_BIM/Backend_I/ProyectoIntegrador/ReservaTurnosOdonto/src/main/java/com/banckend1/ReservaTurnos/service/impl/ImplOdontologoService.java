package com.banckend1.ReservaTurnos.service.Impl;

import com.banckend1.ReservaTurnos.dao.IOdontologoDAO;
import com.banckend1.ReservaTurnos.model.Odontologo;
import com.banckend1.ReservaTurnos.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ImplOdontologoService implements IOdontologoService {

    // Costructor


    public ImplOdontologoService(IOdontologoDAO iOdontologoDAO) {
        this.iOdontologoDAO = iOdontologoDAO;
    }

    @Autowired
    private IOdontologoDAO iOdontologoDAO;

    @Override
    public Odontologo insertOdontologo(Odontologo odontologo) {
        return iOdontologoDAO.save(odontologo);
    }

    @Override
    public Odontologo selectOdontologo(Integer id) {
        return iOdontologoDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteOdontologo(Integer id) {
        iOdontologoDAO.deleteById(id);
    }

    @Override
    public void updateOdontologo(Odontologo odontologo) {
        iOdontologoDAO.save(odontologo);
    }

    @Override
    public List<Odontologo> selectAll() {
        return iOdontologoDAO.findAll();
    }
}
