package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

	private static final String H2_DRIVER = "org.h2.Driver";
	private static final String DB_PATH_NAME = "jdbc:h2:./flota_db";
	private static final String DB_USER = "sa";
	private static final String DB_PSWD = "";

	public static Connection getConnection() throws Exception {
		Class.forName(H2_DRIVER);
		return DriverManager.getConnection(DB_PATH_NAME, DB_USER, DB_PSWD);
	}

	private static final String CREATE_TABLE = "DROP TABLE IF EXISTS flota; CREATE TABLE flota " +
			"(id INT PRIMARY KEY, " +
			"marca VARCHAR(50) NOT NULL, " +
			"modelo VARCHAR(50) NOT NULL, " +
			"matricula VARCHAR(50) NOT NULL, " +
			"ingreso_servicio DATE NOT NULL)";

	public static void createTable() {

		Connection connection = null;
		try {
			connection = getConnection();
			System.out.println("===== CONEXIÓN EXITOSA A LA BD =====");
			Statement stCreateTable = connection.createStatement();
			stCreateTable.execute(CREATE_TABLE);
			System.out.println("***** Creación exitosa de la tabla estudiantes en la BD");
		} catch (Exception e) {
			System.out.println("ERROR: No fue posible conectarse a la BD...");
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("===== SE CERRÓ LA CONEXIÓN A LA BD =====");
			} catch (Exception ex) { ex.printStackTrace();}
		}
	}
}