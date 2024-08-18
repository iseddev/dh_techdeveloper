package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

  private static final Logger LOGGER = Logger.getLogger(BD.class);

  // ============================================================
  private static final String H2_DRIVER = "org.h2.Driver";
  private static final String BD_PATH_NAME = "jdbc:h2:./paciente_bd";
  private static final String BD_USER = "sa";
  private static final String BD_PSWD = "";

  public static Connection getConnection() throws Exception {
    Class.forName(H2_DRIVER);
    return DriverManager.getConnection(BD_PATH_NAME, BD_USER, BD_PSWD);
  }
  // ============================================================


  // ============================================================
  private static final String CREATE_TABLE = "DROP TABLE IF EXISTS PACIENTES; CREATE TABLE PACIENTES " +
      "(ID INT AUTO_INCREMENT PRIMARY KEY, " +
      "NOMBRE VARCHAR(100) NOT NULL, " +
      "APELLIDO VARCHAR(100) NOT NULL, " +
      "DOMICILIO VARCHAR(100) NOT NULL, " +
      "DNI VARCHAR(100) NOT NULL, " +
      "FECHA_ALTA DATE NOT NULL)";
  // ============================================================


  // ============================================================
  public static void crearTabla() {

    Connection connection = null;

    try {
      connection = getConnection();
      LOGGER.info("Inicia conexión a la BD, se creará una tabla");
      Statement statement = connection.createStatement();
      statement.execute(CREATE_TABLE);
    } catch (Exception e) {
      LOGGER.error("*** No fue posible conectarse a la BD ***");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        LOGGER.info("Creación exitosa de la tabla, se cerró la conexión a la BD");
      } catch (Exception ex) {
        LOGGER.error("*** No fue posible cerrar la conexión a la BD ***");
        ex.printStackTrace();
      }
    }
  }
  // ============================================================
}
