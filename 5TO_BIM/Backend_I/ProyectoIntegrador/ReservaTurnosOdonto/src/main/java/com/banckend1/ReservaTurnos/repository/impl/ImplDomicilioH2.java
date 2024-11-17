package com.banckend1.ReservaTurnos.dao.impl;

import com.banckend1.ReservaTurnos.dao.BD;
import com.banckend1.ReservaTurnos.dao.IDAO;
import com.banckend1.ReservaTurnos.model.Domicilio;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ImplDomicilioH2 implements IDAO<Domicilio> {

  private static final Logger LOGGER = Logger.getLogger(ImplDomicilioH2.class);

  private static final String insertRecord = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)";
  private static final String selectById = "SELECT * FROM DOMICILIOS WHERE ID = ?";
  private static final String selectAll = "SELECT * FROM DOMICILIOS";
  private static final String updateRecord = "UPDATE DOMICILIOS SET CALLE = ?, NUMERO = ?, LOCALIDAD = ?, PROVINCIA = ? WHERE ID = ?";
  private static final String deleteById = "DELETE * FROM DOMICILIOS WHERE ID = ?";


  // ############################## CREATE(INSERT) A Domicilio ##############################
  @Override
  public Domicilio insertRecord(Domicilio domicilio) {

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la inserción/creación de un domicilio");

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
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se guardó exitosamente el domicilio: " + domicilio.getCalle());
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return domicilio;
  }


  // ############################## READ(GET) A Domicilio BY ID ##############################
  @Override
  public Domicilio getRecord(Integer id) {

    Connection connection = null;
    Domicilio domicilio = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la consulta de la dirección con id " + id);

      PreparedStatement psSelectById = connection.prepareStatement(selectById);
      psSelectById.setInt(1, id);
      ResultSet rs = psSelectById.executeQuery();

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


  // ############################## READ(GET) ALL Domicilios ##############################
  @Override
  public List<Domicilio> getAllRecords() {

    Connection connection = null;

    List<Domicilio> domicilioList = new ArrayList<>();
    Domicilio domicilio;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la consulta de todos las domicilios");

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


  // ############################## UPDATE A Domicilio ##############################
  @Override
  public void updateRecord(Domicilio domicilio) {

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la modificación del domicilio con id: " + domicilio.getId());

      // ==================================================
      connection.setAutoCommit(false);

      PreparedStatement psUpdateRecord = connection.prepareStatement(updateRecord);
      psUpdateRecord.setString(1, domicilio.getCalle());
      psUpdateRecord.setInt(2, domicilio.getNumero());
      psUpdateRecord.setString(3, domicilio.getLocalidad());
      psUpdateRecord.setString(4, domicilio.getProvincia());
      psUpdateRecord.setInt(5, domicilio.getId());
      psUpdateRecord.execute();

      connection.setAutoCommit(true);
      // ==================================================
    } catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se actualizó el domicilio con id: " + domicilio.getId());
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }


  // ############################## DELETE A Domicilio ##############################
  @Override
  public void deleteRecord(Integer id) {

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia la eliminación del domicilio con id: " + id);

      PreparedStatement psDeleteRecord = connection.prepareStatement(deleteById);
      psDeleteRecord.setInt(1, id);
      psDeleteRecord.executeUpdate();
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        assert connection != null;
        connection.close();
        LOGGER.info("Se eliminó el domicilio con id: " + id);
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
  }
}