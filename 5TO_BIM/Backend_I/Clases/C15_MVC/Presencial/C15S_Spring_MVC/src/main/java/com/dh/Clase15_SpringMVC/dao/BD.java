package com.dh.Clase15_SpringMVC.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

  private static final Logger LOGGER = Logger.getLogger(BD.class);

  public static Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:./odontologia_db", "sa", "");
  }

  private static final String CREATE_PACIENTES = "DROP TABLE IF EXISTS PACIENTES; CREATE TABLE " +
      "PACIENTES (" +
      "ID INT AUTO_INCREMENT PRIMARY KEY," +
      "NOMBRE VARCHAR(100) NOT NULL," +
      "APELLIDO VARCHAR(100) NOT NULL," +
      "DOMICILIO VARCHAR(100) NOT NULL," +
      "DNI VARCHAR(100) NOT NULL," +
      "FECHA_ALTA DATE NOT NULL)";

  private static final String CREATE_ODONTOLOGOS = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE " +
      "ODONTOLOGOS (" +
      "ID INT AUTO_INCREMENT PRIMARY KEY," +
      "NOMBRE VARCHAR(100) NOT NULL," +
      "APELLIDO VARCHAR(100) NOT NULL," +
      "MATRICULA VARCHAR(100) NOT NULL)";

  private static final String INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES ('Daniela', 'Toro', 'DT123')";
  private static final String INSERT_PACIENTE = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DOMICILIO, DNI, FECHA_ALTA) VALUES ('Israel', 'Porfirio', 'Ciudad de México', 'IP123', '2024-4-10')";

  public static void createTables() {
    Connection connection;

    try {
      connection = getConnection();
      LOGGER.info("Se inicia la creación de tablas en la BD");

      Statement statement = connection.createStatement();

      statement.execute(CREATE_PACIENTES);
      LOGGER.info("Se inicia la creación de la tabla pacientes");

      statement.execute(CREATE_ODONTOLOGOS);
      LOGGER.info("Se inicia la creación de la tabla odontologos");

      // De forma "extra", insertamos un registro en odontologos y pacientes, esto no debería hacerse ya que éste método_ sólo debería crear tablas, pero es para fines prácticos.
      statement.execute(INSERT_ODONTOLOGO);
      LOGGER.info("Se insertó un odontologo ");

      statement.execute(INSERT_PACIENTE);
      LOGGER.info("Se insertó un paciente ");

    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      // TODO
    }
  }
}