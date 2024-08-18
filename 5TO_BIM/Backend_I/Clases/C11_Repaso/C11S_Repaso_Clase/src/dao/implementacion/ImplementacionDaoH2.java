package dao.implementacion;

import dao.BD;
import dao.IDao;
import modelo.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionDaoH2  implements IDao<Paciente> {

  @Override
  public Paciente insertRegistro(Paciente paciente) {

    Connection connection = null;

    try {
      connection = BD.getConnectiom();
      System.out.println("===== CONEXIÓN EXITOSA A LA BD =====");

      PreparedStatement psInsert = connection.prepareStatement(
          "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DOMICILIO, DNI, FECHA_ALTA) " +
              "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

      psInsert.setString(1, paciente.getNombre());
      psInsert.setString(2, paciente.getApellido());
      psInsert.setString(3, paciente.getDomicilio());
      psInsert.setString(4, paciente.getDni());
      psInsert.setDate(5, Date.valueOf(paciente.getFechaAlta()));
      psInsert.execute();

      System.out.println("***** Se insertó exitosamente un registro *****");
      // Guardar resultados en records
      ResultSet records = psInsert.getGeneratedKeys();

      // Se recorren los datos obtenidos y se asigna a cada registro el id correspondiente
      while (records.next()) { paciente.setId(records.getInt(1)); }
    } catch (Exception e) {
      System.out.println("ERROR: No fue posible conectarse a la BD...");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        System.out.println("===== SE CERRÓ LA CONEXIÓN A LA BD =====");
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return paciente;
  }

  @Override
  public List<Paciente> selectTodos() {

    Connection connection = null;

    List<Paciente> pacienteList = new ArrayList<>();
    Paciente paciente = null;

    try {
      connection = BD.getConnectiom();
      System.out.println("===== CONEXIÓN EXITOSA A LA BD =====");
      PreparedStatement psSelectAll = connection.prepareStatement("SELECT * FROM PACIENTES");
      ResultSet records = psSelectAll.executeQuery();
      System.out.println("***** Consulta exitosa de todos los registros *****");

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
      System.out.println("ERROR: No fue posible conectarse a la BD...");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        System.out.println("===== SE CERRÓ LA CONEXIÓN A LA BD =====");
      } catch (Exception ex) { ex.printStackTrace(); }
    }
    return pacienteList;
  }

  @Override
  public Paciente selectPorId(Integer id) {
    Connection connection = null;

    try {
      connection = BD.getConnectiom();
      System.out.println("===== CONEXIÓN EXITOSA A LA BD =====");
      PreparedStatement psSelectById = connection.prepareStatement("SELECT * FROM PACIENTES WHERE ID=?");
      psSelectById.setInt(1, id);
      ResultSet selected = psSelectById.executeQuery();

      if (selected.next()) {
        System.out.println("***** Consulta exitosa del registro con ID = " + id + " *****");
        System.out.println("ID: " + selected.getInt("ID"));
        System.out.println("NOMBRE: " + selected.getString(2));
        System.out.println("APELLIDO: " + selected.getString("APELLIDO"));
        System.out.println("COMICILIO: " + selected.getString(4));
        System.out.println("DNI: " + selected.getString("DNI"));
        System.out.println("FECHA_ALTA: " + selected.getDate(6));
      } else {
        System.out.println("La consulta del >> ID = " + id +" <<, no generó ningún resultado");
      }
    } catch (Exception e) {
      System.out.println("ERROR: No fue posible conectarse a la BD...");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        System.out.println("===== SE CERRÓ LA CONEXIÓN A LA BD =====");
      } catch (Exception ex) { ex.printStackTrace(); }
    }
    return null;
  }

  @Override
  public void deletePorId(Integer id) {

    Connection connection = null;

    try {
      connection = BD.getConnectiom();
      System.out.println("===== CONEXIÓN EXITOSA A LA BD =====");

      PreparedStatement psExists = connection.prepareStatement("SELECT * FROM PACIENTES WHERE ID = ?");
      psExists.setInt(1, id);
      System.out.println("psExists.execute(): " + psExists.executeQuery());

      PreparedStatement ps = connection.prepareStatement("DELETE FROM PACIENTES WHERE ID = ?");
      ps.setInt(1, id);
      boolean rs = ps.execute();
      ps.execute();
      System.out.println(rs);

      if (rs) { System.out.println("***** Se eliminó exitosamente el registro con el ID = "+ id + " *****"); }
      else { System.out.println("***** ERROR: No se eliminó ningún registro *****"); }


    } catch (Exception e) {
      System.out.println("ERROR: No fue posible conectarse a la BD...");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        System.out.println("===== SE CERRÓ LA CONEXIÓN A LA BD =====");
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }

  @Override
  public Paciente updateRegistro(Paciente paciente) {

    Connection connection = null;

    try {
      connection = BD.getConnectiom();
      System.out.println("===== CONEXIÓN EXITOSA A LA BD =====");
      PreparedStatement psUpdate = connection.prepareStatement(
          "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, DOMICILIO=?, DNI=?, FECHA_ALTA=? WHERE ID=?");

      psUpdate.setString(1, paciente.getNombre());
      psUpdate.setString(2, paciente.getApellido());
      psUpdate.setString(3, paciente.getDomicilio());
      psUpdate.setString(4, paciente.getDni());
      psUpdate.setDate(5, Date.valueOf(paciente.getFechaAlta()));
      psUpdate.setInt(6, paciente.getId());
      psUpdate.execute();
      System.out.println("*****Se actualizó el nombre y apellido de un registro *****");

      // Guardamos los resultados obtenidos em records
      ResultSet records = psUpdate.getGeneratedKeys();
      // Mostrar resultados
      while (records.next()) { paciente.setId(records.getInt(1)); }
    } catch (Exception e) {
      System.out.println("ERROR: No fue posible conectarse a la BD...");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        System.out.println("===== SE CERRÓ LA CONEXIÓN A LA BD =====");
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return paciente;
  }
}
