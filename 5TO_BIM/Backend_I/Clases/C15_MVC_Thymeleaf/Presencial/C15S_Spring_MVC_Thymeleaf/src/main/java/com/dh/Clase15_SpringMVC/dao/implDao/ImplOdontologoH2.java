package com.dh.Clase15_SpringMVC.dao.implDao;

import com.dh.Clase15_SpringMVC.dao.BD;
import com.dh.Clase15_SpringMVC.dao.IDao;
import com.dh.Clase15_SpringMVC.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplOdontologoH2 implements IDao<Odontologo> {

  private static final Logger LOGGER = Logger.getLogger(ImplPacienteH2.class);

  private static final String selectById = "SELECT * FROM ODONTOLOGOS WHERE ID = ?";
  private static final String selectAll = "SELECT * FROM ODONTOLOGOS";
  private static final String deleteById = "DELETE * FROM PACIENTES WHERE ID = ?";
  private static final String insertRecord = "INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES (?, ?, ?)";
  private static final String updateRecord = "UPDATE ODONTOLOGOS SET NOMBRE = ?, APELLIDO = ?, MATRICULA = ? WHERE ID = ?";


  @Override
  public Odontologo guardar(Odontologo odontologo) {

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la inserción/creación de un odontólogo");

      PreparedStatement psInsertRecord = connection.prepareStatement(insertRecord, Statement.RETURN_GENERATED_KEYS);

      psInsertRecord.setString(1, odontologo.getNombre());
      psInsertRecord.setString(2, odontologo.getApellido());
      psInsertRecord.setString(3, odontologo.getMatricula());
      psInsertRecord.execute();

      ResultSet rs = psInsertRecord.getGeneratedKeys();

      while (rs.next()) {
        odontologo.setId(rs.getInt(1));
      }
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


  @Override
  public List<Odontologo> listarTodos() {

    List<Odontologo> odontologosList = new ArrayList<>();
    Odontologo odontologo;

    Connection connection = null;

    try {

      connection = BD.getConnection();
      LOGGER.info("Se inicia la consulta de todos los odontólogos");

      PreparedStatement psSelectAll = connection.prepareStatement(selectAll);
      ResultSet rs = psSelectAll.executeQuery();

      while (rs.next()) {
        odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        odontologosList.add(odontologo);
        LOGGER.info("Paciente con el id " + odontologo.getId() + " agregado a la consulta");
      }
    } catch (Exception e) { e.printStackTrace(); }
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


  @Override
  public Odontologo consultarPorId(Integer id) {

    Odontologo odontologo = null;

    Connection connection = null;

    try {
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

    } catch (Exception e) { e.printStackTrace(); }
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


  @Override
  public void eliminarPorId(Integer id) {
    Connection connection = null;

    try {
      
      connection = BD.getConnection();
      LOGGER.info("Se inicia la eliminación del odontólogo con id: " + id);

      PreparedStatement psDeleteRecord = connection.prepareStatement(deleteById);
      psDeleteRecord.setInt(1, id);
      psDeleteRecord.executeUpdate();

    } catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se eliminó el odontólogo con id: " + id);
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }


  @Override
  public Odontologo actualizar(Odontologo odontologo) {
    
    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la actualización del odontólogo con id: " + odontologo.getId());

      // ==================================================
      connection.setAutoCommit(false);

      PreparedStatement psUpdateRecord = connection.prepareStatement(updateRecord);
      psUpdateRecord.setString(1,odontologo.getNombre());
      psUpdateRecord.setString(2,odontologo.getApellido());
      psUpdateRecord.setString(3, odontologo.getMatricula());
      psUpdateRecord.setInt(4, odontologo.getId());
      psUpdateRecord.execute();

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
    return odontologo;
  }
}