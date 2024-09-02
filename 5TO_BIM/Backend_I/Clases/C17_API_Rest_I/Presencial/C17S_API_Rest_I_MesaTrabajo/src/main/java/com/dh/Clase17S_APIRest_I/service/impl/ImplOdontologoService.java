package com.dh.Clase17S_APIRest_I.service.impl;

import com.dh.Clase17S_APIRest_I.dao.IDao;
import com.dh.Clase17S_APIRest_I.dao.impl.ImplOdontologoH2;
import com.dh.Clase17S_APIRest_I.model.Odontologo;
import com.dh.Clase17S_APIRest_I.service.IOdontologoService;

import java.util.List;

public class ImplOdontologoService implements IOdontologoService {
    //CREO UN ATRIBUTO DE LA INTERFAZ IDAO
    private final IDao<Odontologo> odontologoIDao;

    //EN EL CONSTRUCTOR INICIALIZO ESA INTERFAZ INDICANDOLE CUAL ES LA IMPLEMENTACION
    public ImplOdontologoService() {
        this.odontologoIDao = new ImplOdontologoH2();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }

    @Override
    public Odontologo buscarPorId(Integer id){
        return odontologoIDao.consultarPorId(id);
    }

    @Override
    public List<Odontologo> listarTodos() {
        return odontologoIDao.listarTodos();
    }

    @Override
    public void actualizar(Odontologo odontologo) { this.odontologoIDao.actualizar(odontologo); }

    @Override
    public void eliminar(Integer id) { this.odontologoIDao.eliminarPorId(id); }
}