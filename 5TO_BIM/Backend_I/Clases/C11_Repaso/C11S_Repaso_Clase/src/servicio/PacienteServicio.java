package servicio;

import dao.Idao;
import dao.implementacion.ImplementacionDaoH2;
import modelo.Paciente;

import java.util.List;

public class PacienteServicio {

  private Idao<Paciente> iDao;

  public PacienteServicio() { this.iDao = new ImplementacionDaoH2(); }

  public  Paciente insertarRegistro(Paciente paciente) { return  iDao.insertarRegistro(paciente); }

  public List<Paciente> consultarTodos() { return iDao.consultarTodos(); }

  public Paciente consultarPorId(Integer id) { return iDao.consultarPorId(id); }

  public Paciente updateRegistro(Paciente paciente) {
    return iDao.actalizarRegistro(paciente);
  }

  public void eliminarPaciente(Integer id) { iDao.eliminarPorId(id); }
}
