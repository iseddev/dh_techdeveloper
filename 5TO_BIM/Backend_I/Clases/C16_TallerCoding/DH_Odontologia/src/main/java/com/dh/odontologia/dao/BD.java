package com.dh.odontologia.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

  private static final Logger LOGGER = Logger.getLogger(BD.class);

  public static Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:./dh_odontologia_db", "sa", "");
  }

  private static final String CREATE_ODONTOLOGOS = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE ODONTOLOGOS " +
      "(ID INT AUTO_INCREMENT PRIMARY KEY," +
      "NOMBRE VARCHAR(100) NOT NULL," +
      "APELLIDO VARCHAR(100) NOT NULL," +
      "MATRICULA VARCHAR(100) NOT NULL)";

  private static final String CREATE_PACIENTES = "DROP TABLE IF EXISTS PACIENTES; CREATE TABLE PACIENTES " +
      "(ID INT AUTO_INCREMENT PRIMARY KEY," +
      "NOMBRE VARCHAR(100) NOT NULL," +
      "APELLIDO VARCHAR(100) NOT NULL," +
      "DNI VARCHAR(100) NOT NULL," +
      "FECHA_ALTA DATE NOT NULL," +
      "DOMICILIO_ID INT NOT NULL)";

  private static final String CREATE_DOMICILIOS = "DROP TABLE IF EXISTS DOMICILIOS; CREATE TABLE DOMICILIOS " +
      "(ID INT AUTO_INCREMENT PRIMARY KEY," +
      "CALLE VARCHAR(100) NOT NULL," +
      "NUMERO INT NOT NULL," +
      "LOCALIDAD VARCHAR(100) NOT NULL," +
      "PROVINCIA VARCHAR(100) NOT NULL)";

  private static final String INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES ('Daniela', 'Toro', 'DT123')";

  private static final String INSERT_DOMICILIO = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES ('Calle Azul', 12, 'Carrodilla', 'Mendoza')";

  private static final String INSERT_PACIENTE = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA_ALTA, DOMICILIO_ID) VALUES ('Israel', 'Porfirio', 'IP123', '2024-4-10', 1)";

  public static void createTables() {

    Connection connection = null;

    try {
      connection = getConnection();
      LOGGER.info("Se inicia la creación de tablas en la BD");

      Statement statement = connection.createStatement();
      statement.execute(CREATE_ODONTOLOGOS);
      statement.execute(CREATE_PACIENTES);
      statement.execute(CREATE_DOMICILIOS);
      LOGGER.info("Se crearon las tablas odontólogos, pacientes y domicilios");

      statement.execute(INSERT_ODONTOLOGO);
      statement.execute(INSERT_DOMICILIO);
      statement.execute(INSERT_PACIENTE);
      LOGGER.info("Se insertaron un odontólogo, un paciente y un domicilio en las tablas correspondientes");

    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se crearon las tablas correspondientes, se cerró la conexión a la BD");
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }
}