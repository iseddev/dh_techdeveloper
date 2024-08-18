package servicio;

import dao.IDao;
import dao.implementacion.ImplementacionDaoH2;
import modelo.Paciente;

import java.util.List;

public class PacienteServicio {

  private IDao<Paciente> IDao;

  public PacienteServicio() { this.IDao = new ImplementacionDaoH2(); }

  public  Paciente insertarRegistro(Paciente paciente) { return  IDao.insertRegistro(paciente); }

  public List<Paciente> consultarTodos() { return IDao.selectTodos(); }

  public Paciente consultarPorId(Integer id) { return IDao.selectPorId(id); }

  public Paciente updateRegistro(Paciente paciente) {
    return IDao.updateRegistro(paciente);
  }

  public void eliminarPaciente(Integer id) { IDao.deletePorId(id); }
}
