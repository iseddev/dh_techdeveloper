package com.banckend1.ReservaTurnos.dao.impl;

import com.banckend1.ReservaTurnos.dao.BD;
import com.banckend1.ReservaTurnos.dao.IDAO;
import com.banckend1.ReservaTurnos.model.Domicilio;
import com.banckend1.ReservaTurnos.model.Paciente;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ImplPacienteH2 implements IDAO<Paciente> {

  private static final Logger LOGGER = Logger.getLogger(ImplPacienteH2.class);

  private static final String insertRecord = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA_ALTA, DOMICILIO_ID) VALUES (?,?,?,?,?)";
  private static final String selectById = "SELECT * FROM PACIENTES WHERE ID = ?";
  private static final String selectAll = "SELECT * FROM PACIENTES";
  private static final String updateRecord = "UPDATE PACIENTES SET NOMBRE = ?, APELLIDO = ?, DNI = ?, FECHA_ALTA = ?, DOMICILIO_ID = ? WHERE ID = ?";
  private static final String deleteById = "DELETE * FROM PACIENTES WHERE ID = ?";

  ImplDomicilioH2 implDomicilioH2 = new ImplDomicilioH2();


  // ############################## CREATE(INSERT) A Paciente ##############################
  // ########## Whit its corresponding DOMICILIO_ID from Paciente ##########
  @Override
  public Paciente insertRecord(Paciente paciente) {

    implDomicilioH2.insertRecord(paciente.getDomicilio()); // First create(insert) a Domicilio
    Connection connection = null;

    try {
      LOGGER.info("Se inicia la inserción/creación de un paciente");
      connection = BD.getConnection();

      PreparedStatement psInsertRecord = connection.prepareStatement(insertRecord, Statement.RETURN_GENERATED_KEYS);

      psInsertRecord.setString(1, paciente.getNombre());
      psInsertRecord.setString(2, paciente.getApellido());
      psInsertRecord.setString(3, paciente.getDni());
      psInsertRecord.setDate(4, Date.valueOf(paciente.getFechaAlta()));
      psInsertRecord.setInt(5, paciente.getDomicilio().getId());
      psInsertRecord.execute();

      ResultSet rs = psInsertRecord.getGeneratedKeys();

      while (rs.next()) {
        paciente.setId(rs.getInt(1));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se guardó exitosamente el paciente: " + paciente.getNombre());
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return paciente;
  }


  // ############################## READ(GET) A Paciente BY ID ##############################
  @Override
  public Paciente getRecord(Integer id) {

    Paciente paciente = null;
    Connection connection = null;

    try {
      LOGGER.info("Se inicia la consulta del paciente con id " + id);
      connection = BD.getConnection();

      PreparedStatement psSelectById = connection.prepareStatement(selectById);
      psSelectById.setInt(1, id);
      ResultSet rs = psSelectById.executeQuery();

      while (rs.next()) {
        Domicilio domicilio = implDomicilioH2.getRecord(rs.getInt(6));
        paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toLocalDate(), domicilio);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Consulta exitosa el paciente con id: " + id);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return paciente;
  }


  // ############################## READ(GET) ALL Pacientes ##############################
  @Override
  public List<Paciente> getAllRecords() {

    List<Paciente> pacientesList = new ArrayList<>();
    Paciente paciente = null;
    Connection connection = null;

    try {
      LOGGER.info("Se inicia la consulta de todos los pacientes");
      connection = BD.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(selectAll);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {

        Domicilio domicilio = implDomicilioH2.getRecord(rs.getInt(6));
        paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toLocalDate(), domicilio);
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


  // ############################## UPDATE A Paciente ##############################
  @Override
  public void updateRecord(Paciente paciente) {

    Domicilio domicilio = implDomicilioH2.getRecord(paciente.getId());
    Connection connection = null;

    try {
      LOGGER.info("Se inicia la modificación del paciente con id: " + paciente.getId());
      connection = BD.getConnection();

      // ==================================================
      connection.setAutoCommit(false);

      PreparedStatement preparedStatement = connection.prepareStatement(updateRecord);
      preparedStatement.setString(1, paciente.getNombre());
      preparedStatement.setString(2, paciente.getApellido());
      preparedStatement.setString(3, paciente.getDni());
      preparedStatement.setDate(4, Date.valueOf(paciente.getFechaAlta()));
      preparedStatement.setInt(5, domicilio.getId());
      preparedStatement.setInt(6, paciente.getId());

      connection.setAutoCommit(true);
      // ==================================================
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se actualizó el paciente con id: " + paciente.getId());
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }


  // ############################## DELETE A Paciente BY ID ##############################
  @Override
  public void deleteRecord(Integer id) {

    Connection connection = null;

    try {
      LOGGER.info("Se inicia la eliminación del paciente con id: " + id);
      connection = BD.getConnection();

      PreparedStatement psDeleteRecord = connection.prepareStatement(deleteById);
      psDeleteRecord.setInt(1, id);
      implDomicilioH2.deleteRecord(this.getRecord(id).getDomicilio().getId());
      psDeleteRecord.executeUpdate();
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se eliminó el paciente con id: " + id);
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }
}