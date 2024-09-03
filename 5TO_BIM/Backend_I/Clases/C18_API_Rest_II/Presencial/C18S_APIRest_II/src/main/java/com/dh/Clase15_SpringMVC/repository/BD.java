package com.dh.Clase15_SpringMVC.repository;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

  private static final Logger LOGGER = Logger.getLogger(BD.class);

  public static Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:./api_rest_ii_db", "sa", "");
  }

  private static final String DROP_CREATE_DOMICILIOS = "DROP TABLE IF EXISTS DOMICILIOS; CREATE TABLE DOMICILIOS (" +
      "ID INT AUTO_INCREMENT PRIMARY KEY," +
      "CALLE VARCHAR(100) NOT NULL," +
      "NUMERO INT NOT NULL," +
      "LOCALIDAD VARCHAR(100) NOT NULL," +
      "PROVINCIA VARCHAR(100) NOT NULL)";

  private static final String DROP_CREATE_PACIENTES = "DROP TABLE IF EXISTS PACIENTES; CREATE TABLE PACIENTES (" +
      "ID INT AUTO_INCREMENT PRIMARY KEY," +
      "NOMBRE VARCHAR(100) NOT NULL," +
      "APELLIDO VARCHAR(100) NOT NULL," +
      "DNI VARCHAR(100) NOT NULL," +
      "FECHA_ALTA DATE NOT NULL," +
      "DOMICILIO_ID INT NOT NULL)"; // Relación con un domicilio, debe estar relacionado correctamente en el modelo paciente

  private static final String DROP_CREATE_ODONTOLOGOS = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE ODONTOLOGOS (" +
      "ID INT AUTO_INCREMENT PRIMARY KEY," +
      "NOMBRE VARCHAR(100) NOT NULL," +
      "APELLIDO VARCHAR(100) NOT NULL," +
      "MATRICULA VARCHAR(100) NOT NULL)";


  private static final String SQL_INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES ('Daniela', 'Toro', '123')";

  private static final String SQL_INSERT_DOMICILIO = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES ('Calle Azul', 12, 'Carrodilla', 'Mendoza')";

  private static final String SQL_INSERT_PACIENTE = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA_ALTA, DOMICILIO_ID) VALUES ('Israel', 'Porfirio', '30.111.111', '2024-08-20', 1)";

  public static void createTable() {

    Connection connection = null;
    try {

      connection = getConnection();

      Statement statement = connection.createStatement();
      statement.execute(DROP_CREATE_ODONTOLOGOS);
      statement.execute(DROP_CREATE_PACIENTES);
      statement.execute(DROP_CREATE_DOMICILIOS);
      LOGGER.info("Estamos creando las tablas odontólogos, pacientes y domicilios");

      statement.execute(SQL_INSERT_ODONTOLOGO);
      statement.execute(SQL_INSERT_DOMICILIO);
      statement.execute(SQL_INSERT_PACIENTE);
      LOGGER.info("Estamos insertando un odontólogo, un paciente y un domicilio en las tablas correspondientes");
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