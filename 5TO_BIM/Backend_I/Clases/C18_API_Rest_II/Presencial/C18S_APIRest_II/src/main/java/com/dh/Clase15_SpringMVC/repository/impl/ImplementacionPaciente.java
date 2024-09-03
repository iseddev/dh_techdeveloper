package com.dh.Clase15_SpringMVC.repository.impl;

import com.dh.Clase15_SpringMVC.repository.BD;
import com.dh.Clase15_SpringMVC.repository.IDAO;
import com.dh.Clase15_SpringMVC.modelo.Domicilio;
import com.dh.Clase15_SpringMVC.modelo.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionPaciente implements IDAO<Paciente> {

  private static final Logger LOGGER = Logger.getLogger(ImplementacionPaciente.class);

  private static final String insertRecord = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA_ALTA, DOMICILIO_ID) VALUES (?,?,?,?,?)";
  private static final String selectAll = "SELECT * FROM PACIENTES";
  private static final String selectById = "SELECT * FROM PACIENTES WHERE ID = ?";
  private static final String deleteById = "DELETE * FROM PACIENTES WHERE ID = ?";
  private static final String updateRecord = "UPDATE PACIENTES SET NOMBRE = ?, APELLIDO = ?, DOMICILIO = ?, DNI = ?, FECHA_ALTA = ? WHERE ID = ?";

  ImplementacionDomicilio implementacionDomicilio = new ImplementacionDomicilio();


  @Override
  public Paciente guardar(Paciente paciente) {

    Connection connection = null;

    try {
      // Creamos una instancia de la implementación domicilio para poder hacer uso de los métodos asociados
      ImplementacionDomicilio implementacionDomicilio = new ImplementacionDomicilio();
      // Guardamos un domicilio que se obtiene del paciente y va a estar asociado a este mismo paciente
      implementacionDomicilio.guardar(paciente.getDomicilio());

      LOGGER.info("Estamos guardando un paciente");

      connection = BD.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(insertRecord, Statement.RETURN_GENERATED_KEYS );

      preparedStatement.setString(1, paciente.getNombre());
      preparedStatement.setString(2, paciente.getApellido());
      preparedStatement.setString(3, paciente.getDni());
      preparedStatement.setDate(4, Date.valueOf(paciente.getFechaAlta()));
      preparedStatement.setInt(5, paciente.getDomicilio().getId());
      preparedStatement.execute();

      ResultSet rs = preparedStatement.getGeneratedKeys();

      while (rs.next()) { paciente.setId(rs.getInt(1)); }
    }
    catch (Exception e) { e.printStackTrace(); }
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
        // Obtenemos un domicilio de acuerdo al id generado en el ResultSet
        Domicilio domicilio = implementacionDomicilio.consultarPorId(rs.getInt(6));

        paciente = new Paciente(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getDate(5).toLocalDate(),
            domicilio);

        pacientesList.add(paciente);
      }
    }
    catch (Exception e) { e.printStackTrace(); }
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

      PreparedStatement preparedStatement = connection.prepareStatement(selectById);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();

      while(rs.next()) {
        Domicilio domicilio = implementacionDomicilio.consultarPorId(rs.getInt(6));

        paciente = new Paciente(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getDate(5).toLocalDate(),
            domicilio);
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
  /*

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
   */
    return null;
  }
}
