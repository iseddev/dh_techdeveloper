import java.sql.*;

public class Animal {

  // Creamos un método estático para realizar la conexión a la BD
  private static Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    String url = "jdbc:h2:./animal"; // Ruta de almacenamiento y nombre que se le asignará a nuestra BD
    return DriverManager.getConnection(url, "sa", "");
  }

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

    // Creamos una conexión en null
    Connection connection = null;

    // Realizamos la conexión dentro de un try/catch, ya que la conexión puede fallar
    try {
      // Conexión a la BD mediante el método estático getConnection() desarrollado fuera de este Main
      connection = getConnection();
      // Este mensaje se mostrará si la conexión a la BD fue exitosa
      System.out.println("Conexión exitosa a BD...");

      // Vamoa a crear una "orden" que será la que ejecutaremos dentro de la BD
      Statement statement = connection.createStatement();

      // Definimos una orden statement que se ejecutará para el manejo inicial de la Tabla
      // En este caso vamos a definir el id(PRIMARY KEY) de forma manual
      statement.execute("DROP TABLE IF EXISTS animal; CREATE TABLE animal(" +
          "ID INT PRIMARY KEY, " +
          "NOMBRE VARCHAR(100) NOT NULL, " +
          "TIPO VARCHAR(100) NOT NULL)");

      // Definimos una orden para INSERT e ingresar datos a la tabla creada anteriormente
      statement.execute("INSERT INTO animal VALUES " +
          "(1, 'Alex', 'León'), " +
          "(2, 'Melman', 'Jirafa'), " +
          "(3, 'Gloria', 'Hipopótamo')");

      // Obtenemos todos los regisros de la tabla mediante la orden SELECT
      ResultSet records = statement.executeQuery("SELECT * FROM animal");

      // Se imprimirán los regitrso "mientras" existan regitros en la tabla => "records.next()"
      System.out.println("========== TODOS LOS REGISTROS ==========");
      while (records.next()) {
//        System.out.println("------------------------------");
        System.out.println("Id: " + records.getInt("ID"));
        System.out.println("Nombre: " + records.getString("NOMBRE"));
        System.out.println("Tipo: " + records.getString("TIPO"));
        System.out.println("------------------------------");
      }

      // Obtenemos registros específicos, en este caso, aquel con el ID = 2
      ResultSet byId = statement.executeQuery("SELECT * FROM animal WHERE ID = 2");
      while (byId.next()) {
        System.out.println("\n========== BÚSQUEDA POR ID ==========");
        System.out.println("Id: " + byId.getInt("ID"));
        System.out.println("Nombre: " + byId.getString("NOMBRE"));
        System.out.println("Tipo: " + byId.getString("TIPO"));
        System.out.println("------------------------------");
      }
    }
    // Este catch es para el manejo de errores, generalmente de conexión a la BD
    catch (Exception e) { System.out.println(e.getMessage()); }
    // Vamos a aplicar un finally para poder cerrar nuestra conexión a la BD
    finally {
      // Usamos try/catch para validar que el cierre de la conexión haya sido exitosa
      try {
        assert connection != null;
        connection.close();
        System.out.println("Conexión a BD cerrada...");
      }
      catch (Exception e) { System.out.println(e.getMessage()); }
    }
  }
}