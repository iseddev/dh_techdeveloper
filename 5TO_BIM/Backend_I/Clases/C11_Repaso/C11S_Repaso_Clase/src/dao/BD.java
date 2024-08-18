package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

  private static final String PATH = "jdbc:h2:./Pacientes";
  private static final String USER = "sa";
  private static final String PSWD = "";

  public static Connection getConnectiom() throws ClassNotFoundException, SQLException {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection(PATH, USER, PSWD);
  }

  private static final String CREATE_TABLE = "DROP TABLE IF EXISTS PACIENTES; CREATE TABLE PACIENTES " +
      "(ID INT AUTO_INCREMENT PRIMARY KEY, " +
      "NOMBRE VARCHAR(100) NOT NULL, " +
      "APELLIDO VARCHAR(100) NOT NULL, " +
      "DOMICILIO VARCHAR(100) NOT NULL, " +
      "DNI VARCHAR(100) NOT NULL, " +
      "FECHA_ALTA DATE NOT NULL)";

  public static void crearTabla() {

    Connection connection = null;

    try {
      connection = getConnectiom();
      System.out.println("===== CONEXIÓN EXITOSA A LA BD =====");
      Statement statement = connection.createStatement();
      statement.execute(CREATE_TABLE);
      System.out.println("***** Creación exitosa de la tabla PACIENTES en la BD");
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
