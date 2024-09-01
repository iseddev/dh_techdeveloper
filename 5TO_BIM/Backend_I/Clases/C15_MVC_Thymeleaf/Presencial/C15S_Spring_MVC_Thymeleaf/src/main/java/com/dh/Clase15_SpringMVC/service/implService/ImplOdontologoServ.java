package com.dh.Clase15_SpringMVC.service.implService;

import com.dh.Clase15_SpringMVC.dao.IDao;
import com.dh.Clase15_SpringMVC.dao.implDao.ImplOdontologoH2;
import com.dh.Clase15_SpringMVC.model.Odontologo;
import com.dh.Clase15_SpringMVC.service.IOdontologoService;

import java.util.List;

public class ImplOdontologoServ implements IOdontologoService {

  // Atributo que instancia de la interfaz IDao
  private final IDao<Odontologo> odontologoIDao;

  // Se asigna la "implementación" a utilizar en el constructor
  public ImplOdontologoServ() {
    this.odontologoIDao = new ImplOdontologoH2();
  }

  @Override
  public Odontologo guardar(Odontologo odontologo) {
    return this.odontologoIDao.guardar(odontologo);
  }

  @Override
  public Odontologo buscarPorId(Integer id){
    return this.odontologoIDao.consultarPorId(id);
  }

  @Override
  public void eliminar(Integer id) { this.odontologoIDao.eliminarPorId(id); }

  @Override
  public void actualizar(Odontologo odontologo) { this.odontologoIDao.actualizar(odontologo); }

  @Override
  public List<Odontologo> listarTodos() { return this.odontologoIDao.listarTodos(); }

}
