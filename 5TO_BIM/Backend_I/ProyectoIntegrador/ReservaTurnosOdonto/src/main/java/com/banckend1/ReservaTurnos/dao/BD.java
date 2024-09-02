package com.banckend1.ReservaTurnos.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final Logger LOGGER = Logger.getLogger(BD.class);

    private static final String DROP_CREATE_DOMICILIOS = "DROP TABLE IF EXISTS DOMICILIOS; CREATE TABLE " +
            "DOMICILIOS (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "CALLE VARCHAR(100) NOT NULL," +
            "NUMERO INT NOT NULL," +
            "LOCALIDAD VARCHAR(100) NOT NULL," +
            "PROVINCIA VARCHAR(100) NOT NULL)";

    private static final String DROP_CREATE_PACIENTES = "DROP TABLE IF EXISTS PACIENTES; CREATE TABLE " +
            "PACIENTES (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL," +
            "DNI VARCHAR(100) NOT NULL," +
            "FECHA_ALTA DATE NOT NULL," +
            "DOMICILIO_ID INT NOT NULL)";

    private static final String DROP_CREATE_ODONTOLOGOS = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE " +
            "ODONTOLOGOS (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL," +
            "MATRICULA VARCHAR(100) NOT NULL)";

    public static void createTable() {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();

            statement.execute(DROP_CREATE_PACIENTES);

            LOGGER.info("Estamos creando la tabla odontologos");
            statement.execute(DROP_CREATE_ODONTOLOGOS);

            statement.execute(DROP_CREATE_DOMICILIOS);

            LOGGER.info("Terminamos de crear las tablas");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Databases/trabajoIntegradorBckn1", "root", " ");
    }
}
