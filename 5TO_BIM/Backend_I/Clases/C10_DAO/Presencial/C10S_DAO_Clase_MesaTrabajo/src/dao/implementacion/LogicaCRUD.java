package dao.implementacion;

import dao.BD;
import dao.IDAO;
import modelo.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;

public class LogicaCRUD implements IDAO<Medicamento> {

  private static final Logger LOGGER = Logger.getLogger(LogicaCRUD.class);

  // ##### Generamos nuestra lógica para insertar un registro en nuestra tabla/BD #####
  @Override
  public Medicamento guardarRegistro(Medicamento medicamento) {

    LOGGER.info("Comenzamos la CREACIÓN del registro de un medicamento");

    Connection connection = null;

    try {
      connection = BD.getConnection();
      System.out.println("===== CONEXIÓN EXITOSA, SE INSERTARÁ UN REGISTRO =====");

      PreparedStatement psInsert = connection.prepareStatement("INSERT INTO MEDICAMENTOS " +
          "(NOMBRE, LABORATORIO, CANTIDAD, PRECIO, CODIGO) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

      psInsert.setString(1, medicamento.getNombre());
      psInsert.setString(2, medicamento.getLaboratorio());
      psInsert.setInt(3, medicamento.getCantidad());
      psInsert.setDouble(4, medicamento.getPrecio());
      psInsert.setInt(5, medicamento.getCodigo());
      psInsert.execute();

      // Obtenemos el registro generado
      ResultSet record = psInsert.getGeneratedKeys();
      // Imprimimos por pantalla los resultados obtenidos
      while(record.next()) {
        medicamento.setId(record.getInt(1));
        LOGGER.info("ID guardado en la BD: " + record.getInt(1));
        LOGGER.info("NOMBRE guardado en la BD: " + medicamento.getNombre());
      }

    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        connection.close();
        System.out.println("===== REGISTRO REALIZADO EXITOSAMENTE, CONEXIÓN CERRADA =====");
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return medicamento;
  }

  // Mesa de Trabajo
  // ##### Generamos la lógica para buscar un registro por Id #####
  @Override
  public Medicamento buscarPorId(Integer id) {

    // TODO lógica de cómo buscar por Id

    LOGGER.info("Comenzamos la BÚSQUEDA de un registro por Id");

    Connection connection = null;

    try {

      connection = BD.getConnection();

      System.out.println("===== CONEXIÓN EXITOSA, SE BUSCARÁ UN REGISTRO POR ID =====");

      PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID=?");
      psSelect.setInt(1, id);

      // Obtenemos el registro generado
      ResultSet record = psSelect.executeQuery();

      System.out.println("ID buscado: " + id);
      System.out.println("========== Resultado de la búsqueda ==========");

      // Imprimimos por pantalla los resultados obtenidos
      if(record.next()) {
        System.out.println("Id: " + record.getInt(1) +
            "\nNombre: " + record.getString(2) +
            "\nLaboratorio: " + record.getString(3) +
            "\nCantidad: " + record.getInt(4) +
            "\nPrecio: " + record.getDouble(5) +
            "\nCódigo: " + record.getInt(6));
          LOGGER.info("Medicamento localizado con el id >>> " + id + " <<< en la BD");
      } else {
        System.out.println("El medicamento con el id >>> " + id + " <<< NO fue localizado en la BD");
        LOGGER.info("Medicamento con el id = " + id + "NO fue localizado en la BD");
      }
    }
    catch (Exception e) { e.printStackTrace(); }
    finally {
      try {
        connection.close();
        System.out.println("===== CONSULTA REALIZADA EXITOSAMENTE, CONEXIÓN CERRADA =====");
      }
      catch (Exception ex) { ex.printStackTrace(); }
    }
    return null;
  }
}
