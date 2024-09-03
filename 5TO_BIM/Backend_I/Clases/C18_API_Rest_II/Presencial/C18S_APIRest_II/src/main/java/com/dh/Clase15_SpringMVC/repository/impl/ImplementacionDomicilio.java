package com.dh.Clase15_SpringMVC.repository.impl;

import com.dh.Clase15_SpringMVC.repository.BD;
import com.dh.Clase15_SpringMVC.repository.IDAO;
import com.dh.Clase15_SpringMVC.modelo.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionDomicilio implements IDAO<Domicilio> {

  private static final Logger LOGGER = Logger.getLogger(ImplementacionDomicilio.class);

  private static final String insertRecord = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)";
  private static final String selectAll = "SELECT * FROM DOMICILIOS";
  private static final String selectById = "SELECT * FROM DOMICILIOS WHERE ID = ?";


  @Override
  public Domicilio guardar(Domicilio domicilio) {

    Connection connection = null;

    try {

      connection = BD.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(insertRecord, Statement.RETURN_GENERATED_KEYS);

      preparedStatement.setString(1, domicilio.getCalle());
      preparedStatement.setInt(2, domicilio.getNumero());
      preparedStatement.setString(3, domicilio.getLocalidad());
      preparedStatement.setString(4, domicilio.getProvincia());
      preparedStatement.execute();

      ResultSet rs = preparedStatement.getGeneratedKeys();

      while (rs.next()) { domicilio.setId(rs.getInt(1)); }
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try { connection.close(); }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return domicilio;
  }

  @Override
  public List<Domicilio> listarTodos() {

    Connection connection = null;

    List<Domicilio> domicilioList = new ArrayList<>();
    Domicilio domicilio;

    try {
      connection = BD.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(selectAll);
      ResultSet rs = preparedStatement.executeQuery();

      while(rs.next()) {
        domicilio = new Domicilio(
            rs.getInt(1),
            rs.getString(2),
            rs.getInt(3),
            rs.getString(4),
            rs.getString(5));
        domicilioList.add(domicilio);
      }
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Consuta exitosa de todos los domicilios");
      } catch (Exception ex) { ex.printStackTrace(); }
    }
    return domicilioList;
  }


  @Override
  public Domicilio consultarPorId(Integer id) {

    Connection connection = null;
    Domicilio domicilio = null;

    try {
      connection = BD.getConnection();

      PreparedStatement psBuscarPorId = connection.prepareStatement(selectById);
      psBuscarPorId.setInt(1, id);
      ResultSet rs = psBuscarPorId.executeQuery();

      while (rs.next()) {
        domicilio = new Domicilio();
        domicilio.setId(rs.getInt(1));
        domicilio.setCalle(rs.getString(2));
        domicilio.setNumero(rs.getInt(3));
        domicilio.setLocalidad(rs.getString(4));
        domicilio.setProvincia(rs.getString(5));

      }
    }
    catch (Exception e) {  e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Consulta exitosa el domicilio con id: " + id);
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return domicilio;
  }


  @Override
  public void eliminarPorId(Integer id) {

  }

  @Override
  public Domicilio actualizar(Domicilio domicilio) {
    return null;
  }
}
