package dao.implementation;

import dao.BD;
import dao.IDao;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteImplDaoH2 implements IDao<Paciente> {

  private static final Logger LOGGER = Logger.getLogger(PacienteImplDaoH2.class);

  private static final String sqlSelectById = "SELECT * FROM PACIENTES WHERE ID = ?";
  private static final String sqlSelectAll = "SELECT * FROM PACIENTES";
  private static final String sqlInsert = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DOMICILIO, DNI, FECHA_ALTA) VALUES (?,?,?,?,?)";
  private static  final String sqlUpdate = "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, DOMICILIO=?, DNI=?, FECHA_ALTA=? WHERE ID=?";
  private static  final  String sqlDelete = "DELETE FROM PACIENTES WHERE ID = ?";

  Connection connection = null;

  // ############################## Listar ##############################
  @Override
  public Paciente selectPorId(Integer id) {
    Connection connection = null;
    Paciente paciente = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia conexión a la BD, se consultará un registro por Id");
      PreparedStatement psSelectById = connection.prepareStatement(sqlSelectById);
      psSelectById.setInt(1, id);
      ResultSet record = psSelectById.executeQuery();

      if (record.next()) {
        paciente = new Paciente(
            record.getString(2),
            record.getString(3),
            record.getString(4),
            record.getString(5),
            record.getDate(6).toLocalDate());
        paciente.setId(record.getInt(1));
        LOGGER.info("Se localizó en la tbala el registro con ID = " + id);
      } else {
        LOGGER.warn("No se encontró ninuguna concidencia para el ID = " + id);
      }
    } catch (Exception e) {
      LOGGER.error("*** No fue posible conectarse a la BD ***");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        LOGGER.info("Consulta exitosa, se cerró la conexión a la BD");
      } catch (Exception ex) {
        LOGGER.error("*** No fue posible cerrar la conexión a la BD ***");
        ex.printStackTrace();
      }
    }
    return paciente;
  }
  
  @Override
  public List<Paciente> selectTodos() {

    Paciente paciente;
    List<Paciente> pacienteList = new ArrayList<>();

    Connection connection = null;
    try {
      connection = BD.getConnection();
      LOGGER.info("Inicia coenxión a la BD, se conaultarán todos los registros");

      PreparedStatement psSelectAll = connection.prepareStatement(sqlSelectAll);
      ResultSet record = psSelectAll.executeQuery();

      while(record.next()) {
        paciente = new Paciente(
            record.getInt(1),
            record.getString(2),
            record.getString(3),
            record.getString(4),
            record.getString(5),
            record.getDate(6).toLocalDate());
        pacienteList.add(paciente);
      }
    } catch (Exception e) {
      LOGGER.error("*** No fue posible conectarse a la BD ***");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        LOGGER.info("Consulta exitosa, se cerró la conexión a la BD");
      } catch (Exception ex) {
        LOGGER.error("*** No fue posible cerra la conexión a la BD ***");
        ex.printStackTrace();
      }
    }
    return pacienteList;
  }


  // ############################## Agregar ##############################
  @Override
  public Paciente insertRegistro(Paciente paciente) {

    try {
      connection = BD.getConnection();
      LOGGER.info("Inicia conexión a la BD, se insertará/guardará un registro.");

      PreparedStatement psInsert = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

      psInsert.setString(1, paciente.getNombre());
      psInsert.setString(2, paciente.getApellido());
      psInsert.setString(3, paciente.getDomicilio());
      psInsert.setString(4, paciente.getDni());
      psInsert.setDate(5, Date.valueOf(paciente.getFechaAlta()));
      psInsert.execute();

      // Guardar el ID generado en un ResultSet de Java
      ResultSet records = psInsert.getGeneratedKeys();

      // Se asinga al registro creado el Id correspondiente
      while (records.next()) { paciente.setId(records.getInt(1)); }
    } catch (Exception e) {
      LOGGER.error("*** No fue posible conectarse a la BD ***");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        LOGGER.info("Se insertó exitosamente un registro en la tabla, conexión a la BD cerrada");
      }
      catch (Exception ex) {
        LOGGER.error("*** No fue posible cerrar la conexión a la BD ***");
        ex.printStackTrace();
      }
    }
    return paciente;
  }


  // ############################## Modificar ##############################
  @Override
  public Paciente updateRegistro(Paciente paciente) {

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inicia conexión a la BD, se actualizará un registro");

      // Evitamos que se envien las modificaciones de forma automática
      connection.setAutoCommit(false);

      PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate);
      psUpdate.setString(1, paciente.getNombre());
      psUpdate.setString(2, paciente.getApellido());
      psUpdate.setString(3, paciente.getDomicilio());
      psUpdate.setString(4, paciente.getDni());
      psUpdate.setDate(5, Date.valueOf(paciente.getFechaAlta()));
      psUpdate.setInt(6, paciente.getId());
      psUpdate.executeUpdate();
      LOGGER.info("Ejecución de la actualización sobre el registro con el ID = " + paciente.getId());

      // Simulación de una Exception
      // int excIntencional = 4/0;

      connection.setAutoCommit(true);

    } catch (Exception e) {
      try {
        connection.rollback();
        LOGGER.error("No se aplicó ningún cambio en el registro con el ID = " + paciente.getId());
      }
      catch (Exception ex) { ex.printStackTrace(); }
      LOGGER.error("*** Se cerró la conexión a la BD ***");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        LOGGER.info("Actualización exitosa, se cerró conexión a la BD");
      }
      catch (Exception exc) {
        LOGGER.error("*** No fue posible cerrar la conexión a la BD ***");
        exc.printStackTrace();
      }
    }
    return paciente;
  }


  // ############################## Eliminar ##############################
  @Override
  public void deletePorId(Integer id) {

    Connection connection = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Se inició conexión a la BD, se eliminará un registro por Id");

      // Evitamos que se envien las modificaciones de forma automática
      connection.setAutoCommit(false);

      PreparedStatement psDelete = connection.prepareStatement(sqlDelete);
      psDelete.setInt(1, id);
      psDelete.executeUpdate();
      LOGGER.info("Se ejecutó proceso de eliminación del registro con ID = " + id);

      connection.setAutoCommit(true);
    } catch (Exception e) {
      try { connection.rollback(); }
      catch (Exception ex) {
        LOGGER.error("*** No pudo eliminarse el registro con el ID = " + id + " ***");
        ex.printStackTrace();
      }
      LOGGER.error("*** No fue posible conectarse a la BD ***");
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        LOGGER.info("Se eliminó exitosamente el registro con ID = " + id + ", se cerró la conexión a la BD");
      }
      catch (Exception ex) {
        LOGGER.error("*** No fue posible cerrar la conexión a la BD ***");
        ex.printStackTrace();
      }
    }
  }
}