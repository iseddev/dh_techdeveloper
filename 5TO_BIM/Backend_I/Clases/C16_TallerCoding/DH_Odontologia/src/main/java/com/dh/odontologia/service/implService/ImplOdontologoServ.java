package com.dh.odontologia.service.implService;

import com.dh.odontologia.dao.IDao;
import com.dh.odontologia.dao.implementation.ImplOdontologoH2;
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
  public Odontologo insertDentist(Odontologo odontologo) {
    return this.odontologoIDao.insertRecord(odontologo);
  }

  @Override
  public Odontologo getDentistById(Integer id){
    return this.odontologoIDao.getRecordById(id);
  }

  @Override
  public List<Odontologo> getDentistsList() { return this.odontologoIDao.getAllRecords(); }

  @Override
  public void updateDentist(Odontologo odontologo) { this.odontologoIDao.updateRecord(odontologo); }

  @Override
  public void deleteDentist(Integer id) { this.odontologoIDao.deleteRecordById(id); }

}
