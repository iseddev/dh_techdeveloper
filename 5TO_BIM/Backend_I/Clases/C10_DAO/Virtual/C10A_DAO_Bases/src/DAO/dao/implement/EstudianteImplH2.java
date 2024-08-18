package DAO.dao.implement;

import DAO.dao.IDAO;
import DAO.model.Estudiante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteImplH2 implements IDAO<Estudiante> {

	// Variables para el manejo de la BD H2
	private final static String H2_DRIVER = "org.h2.Driver";
	private final static String DB_PATH_NAME = "jdbc:h2:./estudiante_db";
	private final static String DB_USER ="sa";
	private final static String DB_PASSWORD = "";


	@Override
	public Estudiante guardar(Estudiante estudiante) {

		// Inicialización de la conexión en null
		Connection connection = null;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psInsert = null;

		try {
			// 1. Levantamos el Driver H2 y hacemos la solicitud de conexión
			Class.forName(H2_DRIVER);
			connection = DriverManager.getConnection(DB_PATH_NAME, DB_USER, DB_PASSWORD);
			System.out.println("Conexión exitosa, agregando registro...");

			// 2. Manejo de las sentencias correspondientes para insertar un registro en la tabla de la BD
			String sqlStatement = "INSERT INTO estudiantes VALUES(?,?,?)";
			psInsert = connection.prepareStatement(sqlStatement);
			psInsert.setInt(1, estudiante.getId());
			psInsert.setString(2, estudiante.getNombre());
			psInsert.setString(3, estudiante.getApellido());

			// 3. Ejecución de la sentencia SQL
			psInsert.executeUpdate();

			psInsert.close();
		}
		catch (Exception e) { e.getStackTrace(); }

		return estudiante;
	}

	@Override
	public void eliminarPorId(Integer id) {

		// Inicialización de la conexión en null
		Connection connection = null;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psDelete = null;

		try {
			// 1. Levantamos el Driver H2 y hacemos la solicitud de conexión
			Class.forName(H2_DRIVER);
			connection = DriverManager.getConnection(DB_PATH_NAME, DB_USER, DB_PASSWORD);

			// 2. Manejo de las sentencias correspondientes para insertar un registro en la tabla de la BD
			String sqlStatement = "DELETE FROM estudiantes WHERE ID = ?";
			psDelete = connection.prepareStatement(sqlStatement);
			psDelete.setInt(1, id);

			// 3. Ejecución de la sentencia SQL
			psDelete.executeUpdate();

			psDelete.close();
		}
		catch (Exception e) { e.getStackTrace(); }
	}

	@Override
	public Estudiante buscarPorId(Integer id) {

		// Inicialización de la conexión en null
		Connection connection = null;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psSelectId = null;
		// Inicializamos un estudiamte em null para que posteriormente le vayamos asignado los valores de cada uno de sus atributos y poder retornarlo.
		Estudiante estudiante = null;

		try {
			// 1. Levantamos el Driver H2 y hacemos la solicitud de conexión
			Class.forName(H2_DRIVER);
			connection = DriverManager.getConnection(DB_PATH_NAME, DB_USER, DB_PASSWORD);

			// 2. Manejo de las sentencias correspondientes para insertar un registro en la tabla de la BD
			String sqlStatement = "SELECT * FROM estudiantes WHERE ID = ?";
			psSelectId = connection.prepareStatement(sqlStatement);
			psSelectId.setInt(1, id);

			// 3. Ejecución de la sentencia SQL. En este caso vamos a guardar todos los campos obtenidos en un "set" de Java que nos ayudará a obtener los valores de cada campo
			ResultSet rsId = psSelectId.executeQuery();

			// 4. Recorremos el "set" con la información obtenida y almacenaremos en variables dichos valores y poder hacer lo que se requiera con dicha información
			while (rsId.next()) {
				Integer ID = rsId.getInt(1);
				String NOMBRE = rsId.getString("nombre");
				String APELLIDO = rsId.getString(3);

				// Instanciamos a estudiante de la Clase Estudiante
				estudiante = new Estudiante();
				// Ahora asignamos estos valores al estudiante que habíamos creado en null (Esto es así porque no creamos un cosntructor en este ejemplo)
				estudiante.setId(ID);
				estudiante.setNombre(NOMBRE);
				estudiante.setApellido(APELLIDO);
			}

			psSelectId.close();
		}
		catch (Exception e) { e.getStackTrace(); }
		return estudiante;
	}

	@Override
	public List<Estudiante> buscarTodos() {

		// Inicialización de la conexión en null
		Connection connection = null;
		// Inicialización de un PreparedStatement en null. Nos servirá para poder pasar por parámetors los valores que queramos pasar de forma dinámica
		PreparedStatement psSelectAll = null;
		// Inicializamos una lista de estudiamtes em null para que posteriormente le vayamos asignando cada registro encontrado
		List<Estudiante> listaEstudiantes = new ArrayList<>();

		try {
			// 1. Levantamos el Driver H2 y hacemos la solicitud de conexión
			Class.forName(H2_DRIVER);
			connection = DriverManager.getConnection(DB_PATH_NAME, DB_USER, DB_PASSWORD);

			// 2. Manejo de las sentencias correspondientes para insertar un registro en la tabla de la BD
			String sqlStatement = "SELECT * FROM estudiantes";
			psSelectAll = connection.prepareStatement(sqlStatement);

			// 3. Ejecución de la sentencia SQL. En este caso vamos a guardar todos los registros obtenidos en un "set" de Java que nos ayudará a obetener los valores de cada registro
			ResultSet rsAll = psSelectAll.executeQuery();

			// 4. Recorremos el "set" con la información obtenida y almacenaremos en variables dichos valores y poder hacer lo que se requiera con dicha información
			while (rsAll.next()) {
				Integer ID = rsAll.getInt("id");
				String NOMBRE = rsAll.getString("nombre");
				String APELLIDO = rsAll.getString("apellido");

				// Creamos un estudiante
				Estudiante estudiante = new Estudiante();
				// Ahora asignamos estos valores al estudiante que habíamos creado en null (Esto es así porque no creamos un cosntructor en este ejemplo)
				estudiante.setId(ID);
				estudiante.setNombre(NOMBRE);
				estudiante.setApellido(APELLIDO);
				System.out.println(estudiante);
				listaEstudiantes.add(estudiante);
			}

			psSelectAll.close();
		}
		catch (Exception e) { e.getStackTrace(); }
		return listaEstudiantes;
	}
}
