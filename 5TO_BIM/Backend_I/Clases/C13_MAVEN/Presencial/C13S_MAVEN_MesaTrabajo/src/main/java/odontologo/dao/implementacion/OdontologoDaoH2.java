package odontologo.dao.implementacion;

import odontologo.dao.BD_Odontologo;
import odontologo.dao.IDao;
import odontologo.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

  private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
  @Override
  public Odontologo insertarRegistro(Odontologo odontologo) {
    LOGGER.info("Comenzamos a persistir un odontólogo");
    Connection connection = null;

    try {

      connection = BD_Odontologo.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(
          "INSERT INTO ODONTOLOGOS (" +
              "NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES " +
              "(?,?,?)", Statement.RETURN_GENERATED_KEYS
      );

      preparedStatement.setString(1, odontologo.getNumeroMatricula());
      preparedStatement.setString(2, odontologo.getNombre());
      preparedStatement.setString(3, odontologo.getApellido());

      preparedStatement.execute();

      //guardando odontologo y generacion del id

      ResultSet rs = preparedStatement.getGeneratedKeys();


      while (rs.next()) {
        odontologo.setId(rs.getInt(1));
        System.out.println("Odontólogo guardado con nombre " +
            odontologo.getNombre());
      }
      LOGGER.info("Se generó el odontologo en la base de datos");
    } catch (Exception e) {
      e.printStackTrace();
      LOGGER.error("No se generó el odontólogo en la base de datos");
    } finally {
      try {
        connection.close();
        LOGGER.info("Se cierra la base de datos");
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return odontologo;
  }

  @Override
  public List<Odontologo> listarTodos() {
    LOGGER.info("Comenzamos a listar a los odontologos");
    Connection connection = null;

    List<Odontologo> odontologoListado = new ArrayList<>();
    Odontologo odontologo = null;

    try {
      connection = BD_Odontologo.getConnection();

      PreparedStatement preparedStatement = connection.prepareStatement(
          "SELECT * FROM ODONTOLOGOS"
      );

      ResultSet rs = preparedStatement.executeQuery();

      while(rs.next()) {
        odontologo = new Odontologo(rs.getString(2),
            rs.getString(3), rs.getString(4));
        odontologo.setId(rs.getInt(1));

        odontologoListado.add(odontologo);

        System.out.println(odontologo.toString());
      }
      LOGGER.info("Se listaron los odontologos");

    } catch (Exception e) {
      e.printStackTrace();
      LOGGER.error("No se pudieron listar los odontologos");
    } finally {
      try {
        connection.close();
        LOGGER.info("Se cierra la base de datos");
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return odontologoListado;
  }
}
