package DAO.service;

import DAO.dao.IDAO;
import DAO.model.Estudiante;

import java.util.List;

public class EstudianteService {

	private IDAO<Estudiante> estudianteIDAO;

	public void setEstudianteIDAO(IDAO<Estudiante> estudianteIDAO) {
		this.estudianteIDAO = estudianteIDAO;
	}


	// Se delega la responsabilidad de la implementación de cada método_ a la interfaz IDAO mediante la implementaciṕn del atributo instanciado, en este caso: estudianteIDAO

	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return estudianteIDAO.guardar(estudiante);
	}

	public void eliminarEstudiantePorId(Integer id) {
		estudianteIDAO.eliminarPorId(id);
	}

	public Estudiante buscarEstudiantePorID(Integer id) {
		return estudianteIDAO.buscarPorId(id);
	}

	public List<Estudiante> buscarTodos() {
		return estudianteIDAO.buscarTodos();
	}
}
