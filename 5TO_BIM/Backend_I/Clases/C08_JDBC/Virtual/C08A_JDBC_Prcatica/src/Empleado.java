import java.sql.*;

public class Empleado {

  // Solicitud de conexión a la BD
  private static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.h2.Driver");
    String url = "jdbc:h2:./EmpleadoBD";
    return DriverManager.getConnection(url, "sa", "");
  }

  public static void main(String[] args) {

    // Creamos una conexión en null
    Connection connection = null;

    // Realizamos la conexión dentro de un try/catch/finally, ya que la conexión puede fallar
    try {

      // Conexión a la BD mediante el método estático getConnection() desarrollado fuera de este Main
      connection = getConnection();
      System.out.println("Conexión exitosa a la BD");

      // Vamoa a crear una "orden" que será la que ejecutaremos dentro de la BD
      Statement statement = connection.createStatement();

      // Definimos una orden DROP-CREATE que se ejecutará para el manejo inicial de la Tabla
      // En este caso vamos a definir el id(PRIMARY KEY) de forma manual
      statement.execute("DROP TABLE IF EXISTS empleados; CREATE TABLE empleados " +
          "(ID INT PRIMARY KEY, " +
          "EDAD INT NOT NULL, " +
          "EMPRESA VARCHAR(100) NOT NULL, " +
          "FECHA_INGRESO VARCHAR(20) NOT NULL)");

      // Definimos una orden para INSERT e ingresar datos a la tabla creada anteriormente
      statement.execute("INSERT INTO empleados VALUES " +
          "(1, 28, 'Digital', '20/03/2020'), " +
          "(2, 26, 'Google', '15/02/2022'), " +
          "(3, 22, 'Facebook', '28/08/2023')");

      // Obtenemos todos los regisros de la tabla mediante la orden SELECT
      ResultSet allRecords = statement.executeQuery("SELECT * FROM empleados");

      // Se imprimiran los regitrso "mientras" existan regitros en la tabla => "allRecords.next()"
      while (allRecords.next()) {
        System.out.println("------------------------------");
        System.out.println("Id: " + allRecords.getInt("ID"));
        System.out.println("Edad: " + allRecords.getString("EDAD"));
        System.out.println("Empresa: " + allRecords.getString("EMPRESA"));
        System.out.println("Ingreso: " + allRecords.getString("FECHA_INGRESO"));
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
        System.out.println("Conexión a la BD cerrada");
      }
      catch (Exception e) { System.out.println(e.getMessage()); }
    }
  }
}
