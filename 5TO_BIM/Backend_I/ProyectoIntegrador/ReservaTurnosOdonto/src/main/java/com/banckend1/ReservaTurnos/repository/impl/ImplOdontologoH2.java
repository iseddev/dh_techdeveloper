package com.banckend1.ReservaTurnos.repository.impl;

import com.banckend1.ReservaTurnos.repository.BD;
import com.banckend1.ReservaTurnos.repository.IDAO;
import com.banckend1.ReservaTurnos.model.Odontologo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ImplOdontologoH2 implements IDAO<Odontologo> {

  private static final Logger LOGGER = Logger.getLogger(ImplOdontologoH2.class);

  private static final String selectById = "SELECT * FROM ODONTOLOGOS WHERE ID = ?";
  private static final String selectAll = "SELECT * FROM ODONTOLOGOS";
  private static final String insertRecord = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES (?, ?, ?)";
  private static final String updateRecord = "UPDATE ODONTOLOGOS SET NOMBRE = ?, APELLIDO = ?, MATRICULA = ? WHERE ID = ?";
  private static final String deleteById = "DELETE * FROM PACIENTES WHERE ID = ?";


  // ############################## CREATE(INSERT) AN Odontologo ##############################
  @Override
  public Odontologo insertRecord(Odontologo odontologo) {

    Connection connection = null;

    try {
      LOGGER.info("Se inicia la inserción/creación de un odontólogo");
      connection = BD.getConnection();

      PreparedStatement psInsert = connection.prepareStatement(insertRecord, Statement.RETURN_GENERATED_KEYS);
      psInsert.setString(1, odontologo.getNombre());
      psInsert.setString(2, odontologo.getApellido());
      psInsert.setString(3, odontologo.getMatricula());
      psInsert.execute();

      ResultSet rs = psInsert.getGeneratedKeys();

      while (rs.next()) { odontologo.setId(rs.getInt(1)); } // Asignar el id generado al registro creado

    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se guardó exitosamente el odontólogo: " + odontologo.getNombre());
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return odontologo;
  }


  // ############################## READ(GET) AN Odontologo BY ID ##############################
  @Override
  public Odontologo getRecord(Integer id) {

    Connection connection = null;
    Odontologo odontologo = null;

    try {
      LOGGER.info("Se inicia la consulta del odontólogo con id " + id);
      connection = BD.getConnection();

      PreparedStatement psSelectById = connection.prepareStatement(selectById);
      psSelectById.setInt(1, id);
      ResultSet rs = psSelectById.executeQuery();

      while (rs.next()) {
        odontologo = new Odontologo();
        odontologo.setId(rs.getInt(1));
        odontologo.setNombre(rs.getString(2));
        odontologo.setApellido(rs.getString(3));
        odontologo.setMatricula(rs.getString(4));
      }
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Consulta exitosa del odontologo con el id " + id);
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return odontologo;
  }


  // ############################## READ(GET) ALL Odontologos ##############################
  @Override
  public List<Odontologo> getAllRecords() {

    List<Odontologo> odontologosList = new ArrayList<>();
    Odontologo odontologo = null;
    Connection connection = null;

    try {
      LOGGER.info("Se inicia la consulta de todos los odontólogos");
      connection = BD.getConnection();

      Statement getAll = connection.createStatement();
      ResultSet rs = getAll.executeQuery(selectAll);

      while (rs.next()) {
        odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        odontologosList.add(odontologo);
        LOGGER.info("Paciente con el id " + odontologo.getId() + " agregado a la consulta");
      }
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Consuta exitosa de todos los odontólogos");
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return odontologosList;
  }


  // ############################## UPDATE AN Odontologo ##############################
  @Override
  public void updateRecord(Odontologo odontologo) {

    Connection connection = null;

    try {
      LOGGER.info("Se inicia la actualización del odontólogo con id: " + odontologo.getId());
      connection = BD.getConnection();

      // ==================================================
      connection.setAutoCommit(false);

      PreparedStatement psUpdateRecord = connection.prepareStatement(updateRecord);
      psUpdateRecord.setString(1, odontologo.getNombre());
      psUpdateRecord.setString(2, odontologo.getApellido());
      psUpdateRecord.setString(3, odontologo.getMatricula());
      psUpdateRecord.setInt(4, odontologo.getId());

      connection.setAutoCommit(true);
      // ==================================================
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se actualizó el odontólogo con id: " + odontologo.getId());
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }


  // ############################## DELETE AN Odontologo BY ID ##############################
  @Override
  public void deleteRecord(Integer id) {

    Connection connection = null;

    try{
      LOGGER.info("Se inicia la actualización del odontólogo con id: " + id);
      connection = BD.getConnection();

      PreparedStatement psDeleteRecord = connection.prepareStatement(deleteById);
      psDeleteRecord.setInt(1, id);
      psDeleteRecord.executeUpdate();

    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se eliminó el odontólogo con id: " + id);
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }
}