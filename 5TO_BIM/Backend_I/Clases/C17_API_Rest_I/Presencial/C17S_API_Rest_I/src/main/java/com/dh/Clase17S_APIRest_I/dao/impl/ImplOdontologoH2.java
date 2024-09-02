package com.dh.Clase17S_APIRest_I.dao.impl;

import com.dh.Clase17S_APIRest_I.dao.BD;
import com.dh.Clase17S_APIRest_I.dao.IDAO;
import com.dh.Clase17S_APIRest_I.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplOdontologoH2 implements IDAO<Odontologo> {

  private static final Logger LOGGER = Logger.getLogger(ImplPacienteH2.class);


  @Override
  public Odontologo guardar(Odontologo odontologo) {

    Connection connection = null;
    String sqlInsert= "INSERT INTO ODONTOLOGOS(NOMBRE, APELLIDO, MATRICULA) VALUES(?,?,?)";

    try {

      connection = BD.getConnection();
      LOGGER.info("Estamos guardando un odontologo");

      PreparedStatement psInsert = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS );

      psInsert.setString(1, odontologo.getNombre());
      psInsert.setString(2, odontologo.getApellido());
      psInsert.setString(3, odontologo.getMatricula());
      psInsert.execute();

      // Guardé el paciente y se generó el id
      ResultSet rs = psInsert.getGeneratedKeys();

      while (rs.next()) {
        odontologo.setId(rs.getInt(1));
        System.out.println("Se guardó el odontologo con nombre " +
            odontologo.getNombre());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try { connection.close(); }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    LOGGER.info("Guardamos el odontologo con nombre " + odontologo.getNombre());
    return odontologo;
  }

  @Override
  public List<Odontologo> listarTodos() {

    Connection connection = null;
    Odontologo odontologo;
    List<Odontologo> odontologoList = new ArrayList<>();
    String sqlSelect = "SELECT * FROM ODONTOLOGOS";

    try {
      connection = BD.getConnection();

      Statement buscarTodos = connection.createStatement();
      ResultSet rs = buscarTodos.executeQuery(sqlSelect);

      while (rs.next()) {
        odontologo = new Odontologo(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4));
        odontologoList.add(odontologo);
      }
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try { connection.close(); }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return odontologoList;
  }

  @Override
  public Odontologo consultarPorId(Integer id) {

    Connection connection = null;
    Odontologo odontologo = null;
    String sqlSelect = "SELECT * FROM ODONTOLOGOS WHERE ID=?";

    try {
      connection = BD.getConnection();

      PreparedStatement psBuscarPorId = connection.prepareStatement(sqlSelect);
      psBuscarPorId.setInt(1, id);
      ResultSet rs = psBuscarPorId.executeQuery();

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
      try { connection.close(); }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return odontologo;
  }

  @Override
  public void eliminarPorId(Integer id) {
    // TODO
  }

  @Override
  public Odontologo actualizar(Odontologo odontologo) {
    // TODO
    return null;
  }
}
