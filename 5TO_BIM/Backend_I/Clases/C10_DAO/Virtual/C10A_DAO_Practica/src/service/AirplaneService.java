package service;

import dao.IDao;
import model.Airplane;

import java.sql.SQLException;
import java.util.List;

public class AirplaneService {

	private IDao<Airplane> airplaneIDao;

	// Aplicando constructor
//	public AirplaneService() { this.airplaneIDao = new AirplaneImplH2(); }

	public void setAirplaneIDao(IDao<Airplane> airplaneIDao) {
		// Este setter puede reemplazarse por el constructor correspondiente
		this.airplaneIDao = airplaneIDao;
	}

	// Definición de los métodos a implementar por este "Service" y la forma en que se delegarán a la lógica definida en la Clase AirplaneImplH2
	public Airplane saveAirplane(Airplane airplane) { return airplaneIDao.insert(airplane);	};
	public List<Airplane> getAirplanes() { return airplaneIDao.selectAll(); }
	public Airplane updateAirplane(Airplane airplane) throws SQLException { return airplaneIDao.update(airplane); };
	public void deleteAirplaneById(Integer id) { airplaneIDao.deleteById(id); };
}