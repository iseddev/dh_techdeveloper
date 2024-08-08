import java.sql.*;

public class Odontologos {

  // Se crean las instrucciones necesarias para crear la tabla requerida
  private static final String DROP_CREATE = "DROP TABLE IF EXISTS odontologos; " +
      "CREATE TABLE odontologos (" +
      "ID INT PRIMARY KEY," +
      "APELLIDO VARCHAR(100) NOT NULL," +
      "NOMBRE VARCHAR(100) NOT NULL," +
      "MATRICULA VARCHAR(100) NOT NULL)";

  private static final String SLQ_INSERT = "INSERT INTO odontologos VALUES (?,?,?,?)";
  private static final String SQL_SELECT_ALL = "SELECT * FROM odontologos";
  private static final String SQL_UPDATE = "UPDATE odontologos SET MATRICULA=? WHERE ID=?";

  public static void main(String[] args) {
    // Inicialización dela conexión en null
    Connection connection = null;

    try {

      // NOS CONECTAMOS A LA BD
      connection = getConnection();
      System.out.println("CONEXIÓN EXITOSA");

      //CREAR LA TABLA
      Statement statement = connection.createStatement();
      statement.execute(DROP_CREATE);

      //INSERTAR VALORES -> DE FORMA DINÁMICA -> PREPARED STATEMENT
      PreparedStatement psSqlInsert = connection.prepareStatement(SLQ_INSERT);
      psSqlInsert.setInt(1,1);
      psSqlInsert.setString(2, "Doe");
      psSqlInsert.setString(3, "John");
      psSqlInsert.setString(4, "ABCD1234");

      // GUARDAMOS LOS DATOS DE LA BD EN JAVA
      psSqlInsert.execute();

      // Obtenemos los registros existentes en la tabla
      ResultSet allRecords = statement.executeQuery(SQL_SELECT_ALL);

      // Recorremos los resultados obtenidos y los imprimimos por pantalla
      System.out.println("===== Datos de los registros originales =====");
      while (allRecords.next()) {
        System.out.println("Id: " + allRecords.getInt(1) +
            "\nNombre: " + allRecords.getString(3) +
            "\nApellido: " + allRecords.getString(2) +
            "\nMatrícula: " + allRecords.getString(4));
      }

      // #################### VAMOS A HACER UNA TRANSACCIÓN ####################
      // Establecemos el "autocommit" en false para evitar que los cambios se "commiteen" de forma automática
      connection.setAutoCommit(false);

      // Realizamos un UPDATE de forma dinaḿica
      PreparedStatement psSqlUpdate = connection.prepareStatement(SQL_UPDATE);
      // Establecemos los cambios para nuetro primer parámetro("paramterIndex = 1") => MATRICULA=?
      psSqlUpdate.setString(1,  "DCBA4321");
      // Establecemos el valor para nuestro segundo parámetro("parameterIndex = 2") => WHERE ID=?
      psSqlUpdate.setInt(2, 1);

      psSqlUpdate.execute();

      // Forzamos un error (Exception) para validar que no se apliquen los cambios realizados anteriormente
      // int excepcionForzada = 1/0;

      // Enviamos los cambios para que sean "commiteados" en la tabla
      connection.commit();

      // UNA BUENA PRÁCTICA
      connection.setAutoCommit(true);
    } catch (Exception e) {
      try { connection.rollback(); } // SE ARROJA LA EXCEPCIÓN Y SE EJECUTA EL ROLLBACK
      catch (Exception ex) { ex.printStackTrace(); }
      e.printStackTrace();
    } finally {
      try {
        connection.close();
        System.out.println("CONEXIÓN CERRADA");
      } catch (Exception e) { e.getMessage(); }
    }

    //----------------------------------------------------------------------------------------------------
    // Volver a conectarnos para validar si se aplicaron o no los cambios ejecutados
    try {
      connection = getConnection();
      System.out.println("CONEXIÓN EXITOSA");

      Statement statement = connection.createStatement();
      ResultSet allRecords = statement.executeQuery(SQL_SELECT_ALL);

      System.out.println("===== Datos despues de actualizar matrícula =====");

      while (allRecords.next()) {
        System.out.println("Id: " + allRecords.getInt(1) +
            "\nNombre: " + allRecords.getString(3) +
            "\nApellido: " + allRecords.getString(2) +
            "\nMatrícula: " + allRecords.getString(4));
      }

    } catch (Exception exception) { exception.printStackTrace(); } finally {
      try {
        connection.close();
        System.out.println("CONEXIÓN CERRADA");
      } catch (Exception e) { e.getMessage(); }
    }
  }

  // Método para conectarnos a la BD
  private static Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:../../../../h2/bin", "sa", "");
  }
}