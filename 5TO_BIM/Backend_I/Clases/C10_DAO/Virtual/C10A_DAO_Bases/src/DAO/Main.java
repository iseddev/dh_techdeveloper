package DAO;

import DAO.dao.DB;
import DAO.dao.implement.EstudianteImplH2;
import DAO.model.Estudiante;
import DAO.service.EstudianteService;

import java.util.List;

public class Main {
	public static void main(String[] args) {

		// Iniciamos con la creación de la tabla estudiantes
		DB.crearTabla();

		// Creamos varios objetos de la Clase Estudiante
		Estudiante e1 = new Estudiante();
		e1.setId(1);
		e1.setNombre("Israel");
		e1.setApellido("Porfirio");

		Estudiante e2 = new Estudiante();
		e2.setId(2);
		e2.setNombre("Eduardo");
		e2.setApellido("Moreno");

		Estudiante e3 = new Estudiante();
		e3.setId(3);
		e3.setNombre("John");
		e3.setApellido("Doe");

		// "Llamamos" al service de Estudiante
		EstudianteService estudianteService = new EstudianteService();
		// Seteamos la implementación necesaria de acuerdo a lo que se requiere, en este caso, es para la implementación de la lógica para el manejo de la BD H2. Aquí es donde podemos hacer las implementaciones de acuerdo a la lógica que el negocio requiera, es decir, elugar de ser H2, puede ser MySQL, PostresSQL, MongoDB, etc...
		estudianteService.setEstudianteIDAO(new EstudianteImplH2());

		estudianteService.guardarEstudiante(e1);
		estudianteService.guardarEstudiante(e2);
		estudianteService.guardarEstudiante(e3);

		System.out.println(estudianteService.buscarEstudiantePorID(1));
		System.out.println(estudianteService.buscarEstudiantePorID(2));
		System.out.println(estudianteService.buscarEstudiantePorID(3));

		System.out.println(estudianteService.buscarTodos());

		estudianteService.eliminarEstudiantePorId(2);
		System.out.println(estudianteService.buscarTodos());

	}
}