import dao.DB;
import dao.implementation.AirplaneImplH2;
import model.Airplane;
import service.AirplaneService;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args) throws SQLException {

		// Iniciamos con la creación de la tabla flota
		DB.createTable();

		// Creamos varios objetos de la Clase Avion
		Airplane a1 = new Airplane(1, "Marca1", "Modelo1", "Matricula1", LocalDate.of(2020,5,18));
		Airplane a2 = new Airplane(2, "Marca2", "Modelo2", "Matricula2", LocalDate.of(2020,2,5));
		Airplane a3 = new Airplane(3, "Marca3", "Modelo3", "Matricula3", LocalDate.of(2020,8,29));

		// "Llamamos" al service de Avion
		AirplaneService airplaneService = new AirplaneService();
		// Seteamos la implementación necesaria de acuerdo a lo que se requiere, en este caso, es para la implementación de la lógica para el manejo de la BD H2. Aquí es donde podemos hacer las implementaciones de acuerdo a la lógica que el negocio requiera, es decir, elugar de ser H2, puede ser MySQL, PostresSQL, MongoDB, etc...
		airplaneService.setAirplaneIDao(new AirplaneImplH2());
		// Para la líne ade código anterior, se puede evitar si se inicializa el constructor en la Clase AirplaneImplH2

		// Realizamos las operaciones correspondientes
		airplaneService.saveAirplane(a1);
		airplaneService.saveAirplane(a2);
		airplaneService.saveAirplane(a3);

		System.out.println(airplaneService.getAirplanes());

		airplaneService.deleteAirplaneById(2);

		System.out.println(airplaneService.getAirplanes());

		Airplane a4 = new Airplane(4, "Marca4", "Modelo4", "Matricula4", LocalDate.of(2019,10,5));

		airplaneService.saveAirplane(a4);

		System.out.println(airplaneService.getAirplanes());

		a1.setMarca("Modificada");
		a1.setModelo("Modificado");
		airplaneService.updateAirplane(a1);

		System.out.println(airplaneService.getAirplanes());

		a4.setMatricula("Modificada");
		airplaneService.updateAirplane(a4);
		System.out.println(airplaneService.getAirplanes());
	}
}