package dao;

import java.sql.*;

public class BD {

  // Ruta de ubicación y credenciales de acceso de la BD de jdbc h2
  private static final String PATH = "jdbc:h2:../../../../../../h2/bin";
  private static final String USER = "sa";
  private static final String PASSWORD = "";

  // Variable para la ejecución de la query necesaria y crear la tabla requerida con los campos necesarios
  private static final String CREATE_TABLE = "DROP TABLE IF EXISTS MEDICAMENTOS;" +
      "CREATE TABLE MEDICAMENTOS " +
      "(ID INT PRIMARY KEY AUTO_INCREMENT," +
      "NOMBRE VARCHAR(100) NOT NULL," +
      "LABORATORIO VARCHAR(100) NOT NULL," +
      "CANTIDAD INT NOT NULL," +
      "PRECIO NUMERIC(10,2)NOT NULL," +
      "CODIGO INT NOT NULL)";

  // Método estático para solicitar la conexión a la BD
  public static Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection(PATH, USER, PASSWORD);
  }

  // Método estático que servirá para la creación de una tabla
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
}