import dao.DB;
import dao.implement.AvionImplementDAOH2;
import model.Avion;
import service.AvionService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws SQLException {

		// Iniciamos con la creación de la tabla flota
		DB.crearTabla();

		// Creamos varios objetos de la Clase Avion
		Avion a1 = new Avion(1, "Marca1", "Modelo1", "Matricula1", LocalDate.of(2020,5,18));

		Avion a2 = new Avion(2, "Marca2", "Modelo2", "Matricula2", LocalDate.of(2020,2,5));

		Avion a3 = new Avion(3, "Marca3", "Modelo3", "Matricula3", LocalDate.of(2020,8,29));

		// "Llamamos" al service de Avion
		AvionService avionService = new AvionService();
		// Seteamos la implementación necesaria de acuerdo a lo que se requiere, en este caso, es para la implementación de la lógica para el manejo de la BD H2. Aquí es donde podemos hacer las implementaciones de acuerdo a la lógica que el negocio requiera, es decir, elugar de ser H2, puede ser MySQL, PostresSQL, MongoDB, etc...
		avionService.setAvionIDao(new AvionImplementDAOH2());

		// Realizamos las operaciones correspondientes
		avionService.insertAvion(a1);
		avionService.insertAvion(a2);
		avionService.insertAvion(a3);

		System.out.println(avionService.selectAllAviones());

		avionService.deleteAvionById(2);

		System.out.println(avionService.selectAllAviones());

		Avion a4 = new Avion(4, "Marca4", "Modelo4", "Matricula4", LocalDate.of(2019,10,5));

		avionService.insertAvion(a4);

		System.out.println(avionService.selectAllAviones());

		a1.setMarca("Modificada");
		a1.setModelo("Modificado");
		avionService.updateAviom(a1);

		System.out.println(avionService.selectAllAviones());

		a4.setMatricula("Modificada");
		avionService.updateAviom(a4);
		System.out.println(avionService.selectAllAviones());
	}
}
