package com.banckend1.ReservaTurnos.service.impl;

import com.banckend1.ReservaTurnos.repository.IDAO;
import com.banckend1.ReservaTurnos.model.Odontologo;
import com.banckend1.ReservaTurnos.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImplOdontologoService implements IOdontologoService {

//  @Autowired
//  private IOdontologoDAO odontologoIDAO;

  private final IDAO<Odontologo> odontologoIDAO;
  public ImplOdontologoService(IDAO<Odontologo> odontologoIDAO) {
    this.odontologoIDAO = odontologoIDAO;
  }

  @Override
  public Odontologo insertOdontologo(Odontologo odontologo) { return odontologoIDAO.insertRecord(odontologo); }

  @Override
  public Odontologo selectOdontologo(Integer id) { return odontologoIDAO.getRecord(id); }

  @Override
  public List<Odontologo> selectAll() {
    return odontologoIDAO.getAllRecords();
  }

  @Override
  public void updateOdontologo(Odontologo odontologo) {
    odontologoIDAO.updateRecord(odontologo);
  }

  @Override
  public void deleteOdontologo(Integer id) {
    odontologoIDAO.deleteRecord(id);
  }
}