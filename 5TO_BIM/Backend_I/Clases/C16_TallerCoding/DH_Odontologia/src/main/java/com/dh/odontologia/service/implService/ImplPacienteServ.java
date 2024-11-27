package com.dh.odontologia.service.implService;

import com.dh.odontologia.dao.IDao;
import com.dh.odontologia.dao.implementation.ImplPacienteH2;
import com.dh.odontologia.model.Paciente;
import com.dh.odontologia.service.IPacienteService;

import java.util.List;

public class ImplPacienteServ implements IPacienteService {

  private final IDao<Paciente> pacienteIDao;

  public ImplPacienteServ() {
    this.pacienteIDao = new ImplPacienteH2();
  }

  @Override
  public Paciente insertPatient(Paciente paciente) { return this.pacienteIDao.insertRecord(paciente); }

  @Override
  public Paciente getPatientById(Integer id) { return pacienteIDao.getRecordById(id); }

  @Override
  public List<Paciente> getPatientsList() { return pacienteIDao.getAllRecords(); }

  @Override
  public void updatePatient(Paciente paciente) { this.pacienteIDao.updateRecord(paciente); }

  @Override
  public void deletePatient(Integer id) { this.pacienteIDao.deleteRecordById(id); }
}