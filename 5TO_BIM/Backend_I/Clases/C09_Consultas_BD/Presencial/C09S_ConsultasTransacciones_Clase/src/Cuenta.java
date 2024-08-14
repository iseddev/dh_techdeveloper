package Clase;

import java.sql.*;

public class Cuenta {

  // Método getConnection() iniciar la conexión a la BD
  private static Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:./CuentaDB", "sa", "");
  }

  private static final String CREATE_TABLE = "DROP TABLE IF EXISTS CUENTAS; CREATE TABLE CUENTAS " +
      "(ID INT PRIMARY KEY, " +
      "NUMERO_CUENTA INT NOT NULL, " +
      "TITULAR VARCHAR(100) NOT NULL, " +
      "SALDO NUMERIC(10,2) NOT NULL)";

  private static final String SLQ_INSERT = "INSERT INTO CUENTAS VALUES (?,?,?,?)";

  private static final String SQL_SELECT_ALL = "SELECT * FROM CUENTAS";

  private static final String SQL_UPDATE = "UPDATE CUENTAS SET SALDO=? WHERE ID=?";



  public static void main(String[] args) {
    //Conectarnos a la BD
    Connection connection = null;
    try {

      //NOS CONECTAMOS A LA BD
      connection = getConnection();
      System.out.println("Conexión exitosa a la BD");

      //CREAR LA TABLA
      Statement statement = connection.createStatement();
      statement.execute(CREATE_TABLE);

      //INSERTAR VALORES -> DE FORMA DINÁMICA -> PREPARED STATEMENT
      PreparedStatement psInsert = connection.prepareStatement(SLQ_INSERT);
      psInsert.setInt(1,1);
      psInsert.setInt(2, 546489864);
      psInsert.setString(3, "Vanina");
      psInsert.setDouble(4, 254766.46);

      psInsert.execute();

      // GUARDAMOS LOS DATOS DE LA BD EN JAVA
      ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);

      // LOS CONSULTAMOS E IMPRIMIMOS POR PANTALLA
      while (rs.next()) {
        System.out.println("La cuenta con id >>" + rs.getInt(1) +
            "<<, número de cuenta " + rs.getInt(2) +
            " y titular " + rs.getString(3) +
            ", tiene como saldo " + rs.getDouble(4));
      }

      // --------------------------------------------------
      // VAMOS A HACER UNA TRANSACCIÓN
      connection.setAutoCommit(false);

      // VOLVEMOS A HACER UNA OPERACIÓN DINAMICA CON PS
      PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
      psUpdate.setDouble(1,10d);
      psUpdate.setInt(2,1);

      psUpdate.execute();

      // --------------------------------------------------
      //FORZAR A QUE OCURRA UNA EXCEPCIÓN
      int excepcionForzada = 4/0;
      // --------------------------------------------------

      // UNA BUENA PRÁCTICA
      connection.setAutoCommit(true);

      // GUARDARMOS EN JAVA LOS DATOS DE LA BD
      ResultSet rs1 = statement.executeQuery(SQL_SELECT_ALL);

      System.out.println("Este es el saldo luego de la transacción");

      while (rs1.next()) {
        System.out.println("La cuenta con id: >>" + rs1.getInt("ID") +
            "<<, número de cuenta " + rs1.getInt("NUMERO_CUENTA") +
            " y titular " + rs1.getString("TITULAR") +
            ", tiene como saldo: " + rs1.getDouble("SALDO"));
      }



    } catch (Exception e) {
      try {
        //SE ARROJA LA EXCEPCIÓN Y SE EJECUTA EL ROLLBACK
        connection.rollback();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      e.printStackTrace();

    } finally {
      try {
        connection.close();
        System.out.println("Conexión cerrada");
      } catch (Exception e) {
        e.getMessage();
      }
    }

    // --------------------------------------------------
    // VOLVER A CONECTARNOS A LA BD PARA CONSULTAR SI EL SALDO EFECTIVAMETE NO CAMBIO
    try {
      connection = getConnection();
      System.out.println("Conexión exitosa a la BD");

      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

      System.out.println("Este es el saldo luego de la transacción:");

      while (resultSet.next()) {
        System.out.println("La cuenta con id <<" + resultSet.getInt(1) +
            "<<, número de cuenta " + resultSet.getInt(2) +
            " y titular " + resultSet.getString(3) +
            " tiene como saldo: " + resultSet.getDouble(4));
      }
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        connection.close();
        System.out.println("Conexión a la BD cerrada");
      } catch (Exception ex) { ex.getMessage(); }
    }
  }
}
