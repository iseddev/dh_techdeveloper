package service;

import dao.IDao;
import model.Avion;

import java.sql.SQLException;
import java.util.List;

public class AvionService {

	private IDao<Avion> avionIDao;

	// Aplicando constructor
	// public AvionService() { this.avionIDao = new AvionImplementDAOH2() };

	public void setAvionIDao(IDao<Avion> avionIDao) {
		// Este setter puede reemplazarse por el constructor correspondiente
		this.avionIDao = avionIDao;
	}

	// Definición de los métodos a implementar por este "Service" y la forma en que se delegarán a la lógica definida en la clase AvionImplementeDAOH2
	public Avion insertAvion(Avion avion) { return avionIDao.insert(avion);	};
	public List<Avion> selectAllAviones() { return avionIDao.selectAll(); }
	public Avion updateAviom(Avion avion) throws SQLException { return avionIDao.update(avion); };
	public void deleteAvionById(Integer id) { avionIDao.deleteById(id); };
}