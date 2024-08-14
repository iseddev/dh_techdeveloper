import java.sql.*;

// 3. Por último, corroborar con una consulta que el paciente existe y que el campo password mantuvo su valor inicial del punto 1.
public class Paciente {

  // Solicitud de conexión a la BD
  private static Connection getConnection() throws ClassNotFoundException, SQLException {
    String url = "jdbc:h2:./PacienteBD";
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection(url, "sa", "");
  }

  // Tenemos que crear una entidad que se llame Pacientes en la base de datos H2 que tenga los siguientes campos: nombre, apellido, domicilio, DNI, fecha de alta, usuario y password.
  private static final String CREATE_TABLE = "DROP TABLE IF EXISTS paciente; CREATE TABLE paciente " +
      "(ID INT PRIMARY KEY," +
      "NOMBRE VARCHAR(50) NOT NULL," +
      "APELLIDO VARCHAR(50) NOT NULL," +
      "DOMICILIO VARCHAR(100) NOT NULL," +
      "DNI VARCHAR(20) NOT NULL," +
      "FECHA_ALTA VARCHAR(15) NOT NULL," +
      "USUARIO VARCHAR(50) NOT NULL," +
      "PASSWORD VARCHAR(50) NOT NULL)";

  // Variable para el paso 1
  private static final String SQL_INSERT = "INSERT INTO paciente VALUES (?,?,?,?,?,?,?,?)";
  // Variable para el paso 2
  private static final String SQL_UPDATE = "UPDATE paciente SET PASSWORD=? WHERE ID=?";
  // Variable para consultar todos los registros
  private static final String SQL_SELECT_ALL = "SELECT * FROM paciente";

  public static void main(String[] args) {

    // 1. Crear una connection a la base de datos e insertar una fila paciente.
    Connection connection = null;

    try {

      // Iniciamos conexión a la BD
      connection = getConnection();
      System.out.println("Conexión exitosa a la BD");

      // Creación de nuestro primer Statement para crear la tabla
      Statement stCreateTable = connection.createStatement();

      // Creamos tabla paciente
      stCreateTable.execute(CREATE_TABLE);

      // Creamos nuestra variable para insertar un registro
      PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);

      // Creamos el proceso para insertar un registro dentro de la tabla
      psInsert.setInt(1,1);
      psInsert.setString(2, "John");
      psInsert.setString(3, "Doe");
      psInsert.setString(4, "Alabama, United States");
      psInsert.setString(5, "AB1C234D");
      psInsert.setString(6, "15/08/2020");
      psInsert.setString(7, "john123");
      psInsert.setString(8, "jonh*123");

      // Ejecutamos el proceso que defnimos anteriormente para que se inserten los valores en la tabla
      psInsert.execute();

      // 2. Luego, abrir una transacción (setAutocommit(false)) y asignar otro password con una sentencia update y, paso siguiente, generar una excepción (throw new Exception).

      // Inicio de la transacción y seteo de setAutoCommit en false para que no se apliquen los cambios de forma automática, sino que se valide que el proceso es el adecuado y después de ello, aplicar los cambios.
      // En caso de existir una Exception, debemos aplicar un rollback()
      connection.setAutoCommit(false);

      // Realizamos la transacción solicitada
      PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
      psUpdate.setString(1,"modified");
      psUpdate.setInt(2,1);

      psUpdate.execute();

      // Generamos una excepción, lo que evitará que el cambio de password sea aplicado y entonces debemos aplicar el rollback para no aplicar ninguna modificación
//      int autoException = 1/0;

      // "Comiteamos" los cambios en la BD
      connection.commit();

      // Si no hay ningún problema, por buenas prácticas, debemos setear el setAutoCommit en true
      connection.setAutoCommit(true);

    }
    catch (Exception e) { // Se "cacha" la excepción que generamos con => int autoException = 1/0;
      try { connection.rollback(); } // Al haber una excepción, se ejecuta el método .rollback() para deshacer cambios y no aplicarlos a la BD
      catch (Exception ex) { ex.printStackTrace(); }
      e.printStackTrace();
    } finally {
      try {
        connection.close();
        System.out.println("Conexión cerrada a la BD");
      }
      catch (Exception exc) { exc.getMessage(); }
    }

    // Verificamos mediante una nueva conexión (debido a que la conexión anterior se cerró) que el password no haya sido modificado en caso de que se haya generado un Exception
    try {
      connection = getConnection();
      System.out.println("Conexión exitosa a la BD");

      Statement stSelectAll = connection.createStatement();
      ResultSet records = stSelectAll.executeQuery(SQL_SELECT_ALL);

      System.out.println("El password original de John Doe es => jonh*123");

      while (records.next()) {
        System.out.println("El pacinte con id: " + records.getInt(1) +
          ", a nombre de " + records.getString(2) +
          ", tiene asignado el password: " + records.getString(8));
      }
    }
    catch(Exception e) { e.printStackTrace(); }
    finally {
      try {
        connection.close();
        System.out.println("Conexión cerrada a la BD");
      }
      catch (Exception ex) { ex.getMessage(); }
    }
  }
}
