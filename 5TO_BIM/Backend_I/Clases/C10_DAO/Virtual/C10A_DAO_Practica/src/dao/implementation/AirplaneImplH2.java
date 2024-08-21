package dao.implementation;

import dao.DB;
import dao.IDao;
import model.Airplane;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirplaneImplH2 implements IDao<Airplane> {

	@Override
	public Airplane insert(Airplane airplane) {

		// Inicialización de la conexión
		Connection connection;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psInsert;

		try {
			connection = DB.getConnection();
			System.out.println("Conexión exitosa a la BD, agregando registro...");

			// 2. Manejo de las sentencias correspondientes para insertar un registro en la tabla de la BD
			String sqlStatement = "INSERT INTO flota (id, marca, modelo, matricula, ingreso_servicio) VALUES(?,?,?,?,?)";
			psInsert = connection.prepareStatement(sqlStatement);
			psInsert.setInt(1, airplane.getId());
			psInsert.setString(2, airplane.getMarca());
			psInsert.setString(3, airplane.getModelo());
			psInsert.setString(4, airplane.getMatricula());
			psInsert.setDate(5, Date.valueOf(airplane.getIngresoServicio()));

			// 3. Ejecución de la sentencia SQL
			psInsert.executeUpdate();

			psInsert.close();
		}
		catch (Exception e) { e.getStackTrace(); }
		return airplane;
	}

	@Override
	public List<Airplane> selectAll() {

		// Inicialización de la conexión
		Connection connection;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psSelectAll;
		// Inicialización de nuestra listaAviones
		List<Airplane> listaAviones = new ArrayList<>();
		// Inicializar un avion
		Airplane airplane = null;

		try {
			connection = DB.getConnection();
			System.out.println("Conexión exitosa a la BD, obteniendo todos los registros...");

			// 2. Manejo de las sentencias correspondientes para consultar todos los registros de la tabla en la BD
			String sqlStatement = "SELECT * FROM flota";
			psSelectAll = connection.prepareStatement(sqlStatement);
			// 3. Ejecución de la sentencia SQL y guardamos en un ResultSet los datos obtenidos para asignarlos a listaAviones
			ResultSet allRecords = psSelectAll.executeQuery();
			while (allRecords.next()) {
				airplane = new Airplane(
						allRecords.getInt(1),
						allRecords.getString(2),
						allRecords.getString(3),
						allRecords.getString(4),
						allRecords.getDate(5).toLocalDate());
				listaAviones.add(airplane);
			}
			psSelectAll.close();
		}
		catch (Exception e) { e.getStackTrace(); }
		return listaAviones;
	}

	@Override
	public Airplane update(Airplane airplane) throws SQLException {

		// Inicialización de la conexión
		Connection connection;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psUpdate;

		try {
			connection = DB.getConnection();
			System.out.println("Conexión exitosa a la BD, actualizando un registro...");

			// 2. Manejo de las sentencias correspondientes para actualizar un registro en la tabla de la BD
			String sqlStatement = "UPDATE flota SET marca = ?, modelo = ?, matricula = ?, ingreso_servicio = ? WHERE id = ?";
			psUpdate = connection.prepareStatement(sqlStatement);
			psUpdate.setString(1, airplane.getMarca());
			psUpdate.setString(2, airplane.getModelo());
			psUpdate.setString(3, airplane.getMatricula());
			psUpdate.setDate(4, Date.valueOf(airplane.getIngresoServicio()));
			psUpdate.setInt(5, airplane.getId());

			// 3. Ejecución de la sentencia SQL y guardamos en un ResultSet los datos obtenidos para mostrarlos por pantalla
			psUpdate.execute();
			System.out.println("Actualización exitosa de un registro");
		}	catch (Exception e) {	throw new RuntimeException(e); }

		psUpdate.close();
		return airplane;
	}

	@Override
	public void deleteById(Integer id) {

		// Inicialización de la conexión
		Connection connection;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psDelete;

		try {
			connection = DB.getConnection();
			System.out.println("Conexión exitosa a la BD, eliminando un registro...");

			// 2. Manejo de las sentencias correspondientes para eliminar el registro en la tabla de la BD de acuerdo al id pasado por parámetro
			String sqlStatement = "DELETE FROM flota WHERE id = ?";
			psDelete = connection.prepareStatement(sqlStatement);
			psDelete.setInt(1, id);

			// 3. Ejecución de la sentencia SQL
			psDelete.executeUpdate();
			System.out.println("Registro eliminado: ");
			psDelete.close();
		}
		catch (Exception e) { e.getStackTrace(); }
	}
}