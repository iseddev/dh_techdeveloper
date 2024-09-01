package com.dh.Clase15_SpringMVC.dao.implDao;

import com.dh.Clase15_SpringMVC.dao.BD;
import com.dh.Clase15_SpringMVC.dao.IDao;
import com.dh.Clase15_SpringMVC.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplPacienteH2 implements IDao<Paciente> {

  private static final Logger LOGGER = Logger.getLogger(ImplPacienteH2.class);
  private static final String selectAll = "SELECT * FROM PACIENTES";
  private static final String selectById = "SELECT * FROM PACIENTES WHERE ID = ?";
  private static final String deleteById = "DELETE * FROM PACIENTES WHERE ID = ?";
  private static final String updateRecord = "UPDATE PACIENTES SET NOMBRE = ?, APELLIDO = ?, DOMICILIO = ?, DNI = ?, FECHA_ALTA = ? WHERE ID = ?";
  private static final String insertRecord = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DOMICILIO, DNI, FECHA_ALTA) VALUES (?,?,?,?,?)";

  @Override
  public Paciente guardar(Paciente paciente) {

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la inserción/creación de un paciente");

      PreparedStatement psInsert = connection.prepareStatement(insertRecord, Statement.RETURN_GENERATED_KEYS);

      psInsert.setString(1, paciente.getNombre());
      psInsert.setString(2, paciente.getApellido());
      psInsert.setString(3, paciente.getDomicilio());
      psInsert.setString(4, paciente.getDni());
      psInsert.setDate(5, Date.valueOf(paciente.getFechaAlta()));
      psInsert.execute();

      // Obtenemos el id generado por la ejecución amterior
      ResultSet rs = psInsert.getGeneratedKeys();

      // Insertamos el id correspondiente en el paciente creado anteriormente
      while (rs.next()) { paciente.setId(rs.getInt(1)); }


    } catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se guardó exitosamente el paciente: " + paciente.getNombre());
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return paciente;
  }


  @Override
  public List<Paciente> listarTodos() {

    List<Paciente> pacientesList = new ArrayList<>();
    Paciente paciente;

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la consulta de todos los pacientes");

      PreparedStatement psSelectAll = connection.prepareStatement(selectAll);
      ResultSet rs = psSelectAll.executeQuery();

      while(rs.next()) {
        paciente = new Paciente(rs.getInt(1), rs.getString(2),
            rs.getString(3), rs.getString(4), rs.getString(5),
            rs.getDate(6).toLocalDate());
        pacientesList.add(paciente);
        LOGGER.info("Paciente con el id " + paciente.getId() + " agregado a la consulta");
      }
    } catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Consuta exitosa de todos los pacientes");
      } catch (Exception ex) { ex.printStackTrace(); }
    }
    return pacientesList;
  }


  @Override
  public Paciente consultarPorId(Integer id) {

    Paciente paciente = null;
    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la consulta del paciente con id " + id);

      PreparedStatement psSelectById = connection.prepareStatement(selectById);
      psSelectById.setInt(1, id);
      ResultSet rs = psSelectById.executeQuery();

      while (rs.next()) {
        paciente = new Paciente();
        paciente.setId(rs.getInt(1));
        paciente.setNombre(rs.getString(2));
        paciente.setApellido(rs.getString(3));
        paciente.setDomicilio(rs.getString(4));
        paciente.setDni(rs.getString(5));
        paciente.setFechaAlta((rs.getDate(6).toLocalDate()));
      }
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Consulta exitosa el paciente con id: " + id);
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return paciente;
  }


  @Override
  public void eliminarPorId(Integer id) {

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la eliminación del paciente con id: " + id);

      PreparedStatement psDeleteRecord = connection.prepareStatement(deleteById);
      psDeleteRecord.setInt(1, id);
      psDeleteRecord.executeUpdate();

    } catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se eliminó el paciente con id: " + id);
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }


  @Override
  public Paciente actualizar(Paciente paciente) {

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la modificación del paciente con id: " + paciente.getId());
      // ==================================================
      connection.setAutoCommit(false);

      PreparedStatement psUpdateRecord = connection.prepareStatement(updateRecord);
      psUpdateRecord.setString(1,paciente.getNombre());
      psUpdateRecord.setString(2,paciente.getApellido());
      psUpdateRecord.setString(3, paciente.getDomicilio());
      psUpdateRecord.setString(4, paciente.getDni());
      psUpdateRecord.setDate(5, Date.valueOf(paciente.getFechaAlta()));
      psUpdateRecord.setInt(6, paciente.getId());
      psUpdateRecord.execute();

      connection.setAutoCommit(true);
      // ==================================================
    } catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se actualizó el paciente con id: " + paciente.getId());
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return paciente;
  }
}