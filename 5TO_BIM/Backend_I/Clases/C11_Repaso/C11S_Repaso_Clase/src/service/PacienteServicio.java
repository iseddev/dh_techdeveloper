package service;

import dao.IDao;
import dao.implementation.PacienteImplDaoH2;
import model.Paciente;

import java.util.List;

public class PacienteServicio {

  private final IDao<Paciente> IDao;

  public PacienteServicio() { this.IDao = new PacienteImplDaoH2(); }

  // ===== Listar =====
  public Paciente selectPorId(Integer id) { return IDao.selectPorId(id); }
  public List<Paciente> selectTodos() { return IDao.selectTodos(); }

  // ===== Agregar =====
  public  Paciente insertRegistro(Paciente paciente) { return  IDao.insertRegistro(paciente); }

  // ===== Modificar =====
  public Paciente updateRegistro(Paciente paciente) {
    return IDao.updateRegistro(paciente);
  }

  // ===== Eliminar =====
  public void deletePorId(Integer id) { IDao.deletePorId(id); }
}