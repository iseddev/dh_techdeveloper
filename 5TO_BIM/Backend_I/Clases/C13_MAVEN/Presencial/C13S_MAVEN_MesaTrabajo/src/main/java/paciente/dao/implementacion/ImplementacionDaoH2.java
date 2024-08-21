package paciente.dao.implementacion;

import paciente.dao.BD_Paciente;
import paciente.dao.Idao;
import paciente.modelo.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionDaoH2  implements Idao<Paciente> {

  @Override
  public Paciente insertarRegistro(Paciente paciente) {

    Connection connection = null;

    try {
      connection = BD_Paciente.getConnectiom();
      System.out.println("##### Conexión iniciada a la BD - Se insertará un registro #####");
      PreparedStatement psInsert = connection.prepareStatement(
          "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DOMICILIO, DNI, FECHA_ALTA) " +
              "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

      psInsert.setString(1, paciente.getNombre());
      psInsert.setString(2, paciente.getApellido());
      psInsert.setString(3, paciente.getDomicilio());
      psInsert.setString(4, paciente.getDni());
      psInsert.setDate(5, Date.valueOf(paciente.getFechaAlta()));

      psInsert.execute();

      // Guardar resultados en records
      ResultSet records = psInsert.getGeneratedKeys();

      // Se recorren los datos obtenidos y se asigna a cada registro el id correspondiente
      while (records.next()) { paciente.setId(records.getInt(1)); }
    } catch (Exception e) {
      System.out.println("ERROR: No fue posible conectarse a la BD");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        System.out.println("Registro exitoso, se ha cerrado la conexión a la BD");
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return paciente;
  }

  @Override
  public List<Paciente> consultarTodos() {

    Connection connection = null;

    List<Paciente> pacienteList = new ArrayList<>();
    Paciente paciente = null;

    try {
      connection = BD_Paciente.getConnectiom();
      System.out.println("##### Conexión iniciada a la BD - Se consultarán todos los registros #####");
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTES");
      ResultSet records = preparedStatement.executeQuery();

      while(records.next()) {
        paciente = new Paciente(
            records.getInt(1),
            records.getString(2),
            records.getString(3),
            records.getString(4),
            records.getString(5),
            records.getDate(6).toLocalDate());

        pacienteList.add(paciente);
        System.out.println(paciente.toString());
      }
    } catch (Exception e) {
      System.out.println("ERROR: No fue posible conectarse a la BD");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        System.out.println("Consulta exitosa, se ha cerrado la conexión a la BD");
      } catch (Exception ex) { ex.printStackTrace(); }
    }
    return pacienteList;
  }

  @Override
  public Paciente consultarPorId(Integer id) {
    return null;
  }

  @Override
  public void eliminarPorId(Integer id) {}

  @Override
  public Paciente actalizarRegistro(Paciente paciente) {

    Connection connection = null;

    try {
      connection = BD_Paciente.getConnectiom();
      System.out.println("##### Conexión iniciada a la BD - Se actualizará el nombre y apellido en un registro #####");
      PreparedStatement psUpdate = connection.prepareStatement(
          "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, DOMICILIO=?, DNI=?, FECHA_ALTA=? WHERE ID=?");

      psUpdate.setString(1, paciente.getNombre());
      psUpdate.setString(2, paciente.getApellido());
      psUpdate.setString(3, paciente.getDomicilio());
      psUpdate.setString(4, paciente.getDni());
      psUpdate.setDate(5, Date.valueOf(paciente.getFechaAlta()));
      psUpdate.setInt(6, paciente.getId());
      psUpdate.execute();

      // Guardamos los resultados obtenidos em records
      ResultSet records = psUpdate.getGeneratedKeys();
      // Mostrar resultados
      while (records.next()) { paciente.setId(records.getInt(1)); }
    } catch (Exception e) {
      System.out.println("ERROR: No fue posible conectarse a la BD");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        System.out.println("Actualización exitoso, se ha cerrado la conexión a la BD");
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return paciente;
  }
}
