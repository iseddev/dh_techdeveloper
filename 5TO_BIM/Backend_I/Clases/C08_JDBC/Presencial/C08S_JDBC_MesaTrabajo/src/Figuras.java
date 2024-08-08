import java.sql.*;

public class Figuras {
  public static void main(String[] args) {
    // Iniciamos la conexión a la BD en null
    Connection connection = null;

    // Creamos un try/cacht/finally para el manejo de la coexión a la BD
    try {

      // Solicitamos conexión a la BD
      connection = getConnection();

      // Creamos orden para el manejo de la tabla mediante queries
      Statement statement = connection.createStatement();

      // Creamos la tabla solicitada
      statement.execute("DROP TABLE IF EXISTS figuras;" +
          "CREATE TABLE figuras (" +
          "ID INT PRIMARY KEY, " +
          "FIGURA VARCHAR(50) NOT NULL, " +
          "COLOR VARCHAR(50) NOT NULL)");

      // Insertamos registros a la tabla
      statement.execute("INSERT INTO figuras VALUES " +
          "(1, 'Círculo', 'Rojo'), " +
          "(2, 'Círculo', 'Amarillo'), " +
          "(3, 'Cuadrado', 'Verde'), " +
          "(4, 'Cuadrado', 'Morado'), " +
          "(5, 'Cuadrado', 'Azul')");

      // Obtener circulos de color rojo
      ResultSet byColor = statement.executeQuery("SELECT * FROM figuras WHERE COLOR = 'Rojo'");
      // Imprmimos los resultados obtenidos
      while (byColor.next()) {
        System.out.println("------------------------------");
        System.out.println("Id: " + byColor.getInt("ID"));
        System.out.println("Figura: " + byColor.getString("FIGURA"));
        System.out.println("Color: " + byColor.getString("COLOR"));
        System.out.println("------------------------------");
      }

      // Obtener todos los registros
      ResultSet allRecords = statement.executeQuery("SELECT * FROM figuras");
      // Imprimir en pantalla los registros obtenidos
      while (allRecords.next()) {
        System.out.println("------------------------------");
        System.out.println("Id: " + allRecords.getInt("ID"));
        System.out.println("Figura: " + allRecords.getString("FIGURA"));
        System.out.println("Color: " + allRecords.getString("COLOR"));
        System.out.println("------------------------------");
      }

    }
    catch (Exception e) { System.out.println("Error de conexión => " + e.getMessage()); }
    finally {
      // Usamos try/catch para validar que el cierre de la conexión haya sido exitosa
      try {
        assert connection != null;
        System.out.println("Cerrando conexión a BD...");
        connection.close();
        System.out.println("Conexión a BD cerrada...");
      }
      catch (Exception e) { System.out.println(e.getMessage()); }
    }
  }

  // Método estático para la conexión a la BD
  private static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.h2.Driver");
    String url = "jdbc:h2:../../../../h2/bin";
    return DriverManager.getConnection(url, "sa", "");
  }
}