package dao.implement;

import dao.IDao;
import model.Avion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvionImplementDAOH2 implements IDao<Avion> {

	// Variables para el manejo de la BD H2
	private final static String H2_DRIVER = "org.h2.Driver";
	private final static String DB_PATH_NAME = "jdbc:h2:./flota_db";
	private final static String DB_USER ="sa";
	private final static String DB_PASSWORD = "";

	@Override
	public Avion insert(Avion avion) {

		// Inicialización de la conexión
		Connection connection;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psInsert;

		try {
			// 1. Levantamos el Driver H2 y hacemos la solicitud de conexión
			Class.forName(H2_DRIVER);
			connection = DriverManager.getConnection(DB_PATH_NAME, DB_USER, DB_PASSWORD);
			System.out.println("Conexión exitosa a la BD, agregando registro...");

			// 2. Manejo de las sentencias correspondientes para insertar un registro en la tabla de la BD
			String sqlStatement = "INSERT INTO flota (id, marca, modelo, matricula, ingreso_servicio) VALUES(?,?,?,?,?)";
			psInsert = connection.prepareStatement(sqlStatement);
			psInsert.setInt(1, avion.getId());
			psInsert.setString(2, avion.getMarca());
			psInsert.setString(3, avion.getModelo());
			psInsert.setString(4, avion.getMatricula());
			psInsert.setDate(5, Date.valueOf(avion.getIngresoServicio()));

			// 3. Ejecución de la sentencia SQL
			psInsert.executeUpdate();

			psInsert.close();
		}
		catch (Exception e) { e.getStackTrace(); }
		return avion;
	}

	@Override
	public List<Avion> selectAll() {

		// Inicialización de la conexión
		Connection connection;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psSelectAll;
		// Inicialización de nuestra listaAviones
		List<Avion> listaAviones = new ArrayList<>();
		// Inicializar un avion
		Avion avion = null;

		try {
			// 1. Levantamos el Driver H2 y hacemos la solicitud de conexión
			Class.forName(H2_DRIVER);
			connection = DriverManager.getConnection(DB_PATH_NAME, DB_USER, DB_PASSWORD);
			System.out.println("Conexión exitosa a la BD, obteniendo todos los registros...");

			// 2. Manejo de las sentencias correspondientes para consultar todos los registros de la tabla en la BD
			String sqlStatement = "SELECT * FROM flota";
			psSelectAll = connection.prepareStatement(sqlStatement);
			// 3. Ejecución de la sentencia SQL y guardamos en un ResultSet los datos obtenidos para asignarlos a listaAviones
			ResultSet allRecords = psSelectAll.executeQuery();
			while (allRecords.next()) {
				avion = new Avion(
						allRecords.getInt(1),
						allRecords.getString(2),
						allRecords.getString(3),
						allRecords.getString(4),
						allRecords.getDate(5).toLocalDate());
				listaAviones.add(avion);
			}
			psSelectAll.close();
		}
		catch (Exception e) { e.getStackTrace(); }
		return listaAviones;
	}

	@Override
	public Avion update(Avion avion) throws SQLException {

		// Inicialización de la conexión
		Connection connection;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psUpdate;

		try {
			// 1. Levantamos el Driver H2 y hacemos la solicitud de conexión
			Class.forName(H2_DRIVER);
			connection = DriverManager.getConnection(DB_PATH_NAME, DB_USER, DB_PASSWORD);
			System.out.println("Conexión exitosa a la BD, actualizando un registro...");

			// 2. Manejo de las sentencias correspondientes para actualizar un registro en la tabla de la BD
			String sqlStatement = "UPDATE flota SET marca = ?, modelo = ?, matricula = ?, ingreso_servicio = ? WHERE id = ?";
			psUpdate = connection.prepareStatement(sqlStatement);
			psUpdate.setString(1, avion.getMarca());
			psUpdate.setString(2, avion.getModelo());
			psUpdate.setString(3, avion.getMatricula());
			psUpdate.setDate(4, Date.valueOf(avion.getIngresoServicio()));
			psUpdate.setInt(5, avion.getId());

			// 3. Ejecución de la sentencia SQL y guardamos en un ResultSet los datos obtenidos para mostrarlos por pantalla
			psUpdate.execute();
			System.out.println("Actualización exitosa de un registro");
		}	catch (ClassNotFoundException | SQLException e) {	throw new RuntimeException(e); }

		psUpdate.close();
		return avion;
	}

	@Override
	public void deleteById(Integer id) {

		// Inicialización de la conexión
		Connection connection;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psDelete;

		try {
			// 1. Levantamos el Driver H2 y hacemos la solicitud de conexión
			Class.forName(H2_DRIVER);
			connection = DriverManager.getConnection(DB_PATH_NAME, DB_USER, DB_PASSWORD);
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