package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

  public static Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:./maven_paciente_db", "sa", "");
  }

  private static final String CREATE_TABLE = "DROP TABLE IF EXISTS PACIENTES; CREATE TABLE PACIENTES " +
      "(ID INT AUTO_INCREMENT PRIMARY KEY," +
      "NOMBRE VARCHAR(100) NOT NULL," +
      "APELLIDO VARCHAR(100) NOT NULL," +
      "DOMICILIO VARCHAR(100) NOT NULL," +
      "DNI VARCHAR(100) NOT NULL," +
      "FECHA_ALTA DATE NOT NULL)";

  public static void createTable() {
    Connection connection = null;

    try {
      connection = getConnection();
      Statement statement = connection.createStatement();
      statement.execute(CREATE_TABLE);
    } catch (Exception e) {	e.printStackTrace(); }
    finally {
      try { connection.close(); }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }
}
