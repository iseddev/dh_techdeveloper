package dao;

import java.sql.*;

public class BD {

  // *************** SOLICITUD/MANEJO DE CONEXIÓN A BASE DE DATOS ***************
  // Ruta de ubicación y credenciales de acceso a la BD de JDBC H2
  private static final String H2_DRIVER = "org.h2.Driver";
  private static final String BD_PATH_NAME = "jdbc:h2:./medicamento_db";
  private static final String BD_USER = "sa";
  private static final String BD_PASSWORD = "";

  // Método_ estático para solicitar la conexión a la BD
  public static Connection getConnection() throws Exception {
    Class.forName(H2_DRIVER);
    return DriverManager.getConnection(BD_PATH_NAME, BD_USER, BD_PASSWORD);
  }
  // *************** FIN SOLICITUD/MANEJO DE CONEXIÓN A BASE DE DATOS ***************


  // *************** SENTENCIA SQL PARA CREAR TABLA EN LA BD ***************
  private static final String CREATE_TABLE = "DROP TABLE IF EXISTS MEDICAMENTOS; " +
      "CREATE TABLE MEDICAMENTOS " +
      "(ID INT PRIMARY KEY AUTO_INCREMENT," +
      "NOMBRE VARCHAR(100) NOT NULL," +
      "LABORATORIO VARCHAR(100) NOT NULL," +
      "CANTIDAD INT NOT NULL," +
      "PRECIO NUMERIC(10,2)NOT NULL," +
      "CODIGO INT NOT NULL)";
  // *************** FIN SENTENCIA SQL PARA CREAR TABLA EN LA BD ***************


  // *************** MÉTODO_ PARA LA EJECUCIÓN DE LA CREACIÓN DE LA TABLA ***************
  public static void createTable() {

    // Inicializamos la conexíón a la BD como null
    Connection connection = null;

    // Manejamos con try/catch/finally la conexión a la BD
    try {
      connection = getConnection();
      System.out.println("===== CONEXIÓN EXITOSA, SE CREARÁ UNA TABLA =====");

      // Creamos un statemente para realizar las ejecuciones requeridas
      Statement statement = connection.createStatement();

      // Ejecutamos la creación de nuestra tabla
      statement.execute(CREATE_TABLE);
    }
    catch(Exception e){ e.printStackTrace(); }
    finally {
      try {
        connection.close();
        System.out.println("===== TABLA CREADA EXITOSAMENTE, CONEXIÓN CERRADA =====");
      }
      catch (Exception e) { e.printStackTrace(); }
    }
  }
  // *************** FIN MÉTODO_ PARA LA EJECUCIÓN DE LA CREACIÓN DE LA TABLA ***************
}