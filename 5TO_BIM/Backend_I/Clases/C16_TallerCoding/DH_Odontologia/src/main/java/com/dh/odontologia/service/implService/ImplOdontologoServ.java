package com.dh.odontologia.service.implService;

import com.dh.odontologia.dao.IDao;
import com.dh.odontologia.dao.implDao.ImplOdontologoH2;
import com.dh.odontologia.model.Odontologo;
import com.dh.odontologia.service.IOdontologoService;

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
