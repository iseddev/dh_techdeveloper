package com.dh.odontologia.dao.implementation;

import com.dh.odontologia.dao.BD;
import com.dh.odontologia.dao.IDao;
import com.dh.odontologia.model.Domicilio;
import com.dh.odontologia.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplPacienteH2 implements IDao<Paciente> {

  private static final Logger LOGGER = Logger.getLogger(ImplPacienteH2.class);

  private static final String insertRecord = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA_ALTA, DOMICILIO_ID) VALUES (?,?,?,?,?)";
  private static final String selectById = "SELECT * FROM PACIENTES WHERE ID = ?";
  private static final String selectAll = "SELECT * FROM PACIENTES";
  private static final String updateRecord = "UPDATE PACIENTES SET NOMBRE = ?, APELLIDO = ?, DNI = ?, FECHA_ALTA = ?, DOMICILIO_ID = ? WHERE ID = ?";
  private static final String deleteById = "DELETE * FROM PACIENTES WHERE ID = ?";

  ImplDomicilioH2 implDomicilio = new ImplDomicilioH2(); // Instanciamos la implDomicilio


  // ############################## CREATE(INSERT) A PATIENT ##############################
  // ########## Whit its corresponding DOMICILIO_ID from paciente ##########
  @Override
  public Paciente insertRecord(Paciente paciente) {

    implDomicilio.insertRecord(paciente.getDomicilio()); // Creamos un Domicilio proveniente de Paciente
    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la inserción/creación de un paciente");

      PreparedStatement psInsert = connection.prepareStatement(insertRecord, Statement.RETURN_GENERATED_KEYS);

      psInsert.setString(1, paciente.getNombre());
      psInsert.setString(2, paciente.getApellido());
      psInsert.setString(3, paciente.getDni());
      psInsert.setDate(4, Date.valueOf(paciente.getFechaAlta()));
      psInsert.setInt(5, paciente.getDomicilio().getId());
      psInsert.execute();

      ResultSet rs = psInsert.getGeneratedKeys();

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


  // ############################## READ(GET) PATIENT BY ID ##############################
  @Override
  public Paciente getRecordById(Integer id) {

    Paciente paciente = null;
    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la consulta del paciente con id " + id);

      PreparedStatement psSelectById = connection.prepareStatement(selectById);
      psSelectById.setInt(1, id);
      ResultSet rs = psSelectById.executeQuery();

      while (rs.next()) {
        Domicilio domicilio = implDomicilio.getRecordById(rs.getInt(6)); // DOMICILIO_ID
        paciente = new Paciente();
        paciente.setId(rs.getInt(1));
        paciente.setNombre(rs.getString(2));
        paciente.setApellido(rs.getString(3));
        paciente.setDni(rs.getString(4));
        paciente.setFechaAlta((rs.getDate(5).toLocalDate()));
        paciente.setDomicilio(domicilio);
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


  // ############################## READ(GET) ALL PATIENTS ##############################
  @Override
  public List<Paciente> getAllRecords() {

    List<Paciente> pacientesList = new ArrayList<>();
    Paciente paciente;
    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la consulta de todos los pacientes");

      PreparedStatement psSelectAll = connection.prepareStatement(selectAll);
      ResultSet rs = psSelectAll.executeQuery();

      while(rs.next()) {
        Domicilio domicilio = implDomicilio.getRecordById(rs.getInt(6));
        paciente = new Paciente(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getDate(5).toLocalDate(),
            domicilio);
            pacientesList.add(paciente);
        LOGGER.info("Paciente con el id " + paciente.getId() + " agregado a la consulta");
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


  // ############################## UPDATE A PATIENT ##############################
  @Override
  public void updateRecord(Paciente paciente) {

    Connection connection = null;
    Domicilio domicilio = implDomicilio.getRecordById(paciente.getId());

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la modificación del paciente con id: " + paciente.getId());
      // ==================================================
      connection.setAutoCommit(false);

      PreparedStatement psUpdateRecord = connection.prepareStatement(updateRecord);
      psUpdateRecord.setString(1,paciente.getNombre());
      psUpdateRecord.setString(2,paciente.getApellido());
      psUpdateRecord.setString(3, paciente.getDni());
      psUpdateRecord.setDate(4, Date.valueOf(paciente.getFechaAlta()));
      psUpdateRecord.setObject(5, domicilio);
      psUpdateRecord.setInt(6, paciente.getId());
      psUpdateRecord.execute();

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


  // ############################## DELETE A PATIENT BY ID ##############################
  @Override
  public void deleteRecordById(Integer id) {

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la eliminación del paciente con id: " + id);

      PreparedStatement psDeleteRecord = connection.prepareStatement(deleteById);
      psDeleteRecord.setInt(1, id);
      implDomicilioH2.deleteRecordById(this.getRecordById(id).getDomicilio().getId());
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
