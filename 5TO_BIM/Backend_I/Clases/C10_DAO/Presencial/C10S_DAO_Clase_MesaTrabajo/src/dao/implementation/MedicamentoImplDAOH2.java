package dao.implementation;

import dao.BD;
import dao.IDAO;
import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;

public class MedicamentoImplDAOH2 implements IDAO<Medicamento> {

  private static final Logger LOGGER = Logger.getLogger(MedicamentoImplDAOH2.class);

  // ##### Generamos nuestra lógica para insertar(Crear) un registro en nuestra tabla/BD #####
  @Override
  public Medicamento insert(Medicamento medicamento) {

    LOGGER.info("Inicia la creación(insert) de un medicamento en la tabla");

    Connection connection = null;

    try {
      // Esta connection está usando la lógica implementadoa en el método_ getConnection() de la clase BD
      connection = BD.getConnection();
      LOGGER.info("Conexión exitosa a la BD, se creará un nuevo registro");
      System.out.println("===== Conexión exitosa a la BD, se creará un nuevo registro =====");

      String sqlStatement = "INSERT INTO MEDICAMENTOS (NOMBRE, LABORATORIO, CANTIDAD, PRECIO, CODIGO) VALUES (?,?,?,?,?)";
      PreparedStatement psInsert = connection.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
      // Statement.RETURN_GENERATED_KEYS nos ayuda a que de forma automática se genere y asigne un ID auto-incremental

      psInsert.setString(1, medicamento.getNombre());
      psInsert.setString(2, medicamento.getLaboratorio());
      psInsert.setInt(3, medicamento.getCantidad());
      psInsert.setDouble(4, medicamento.getPrecio());
      psInsert.setInt(5, medicamento.getCodigo());
      psInsert.execute();
      LOGGER.info("Ejecución correcta de la creación/inserción de un registro en la tabla");

      // Obtenemos la PrimaryKey de la BD que se generó y la almacenamos en un ResultSet de Java para asignarla al registro creado
      ResultSet record = psInsert.getGeneratedKeys();
      while(record.next()) {
        medicamento.setId(record.getInt(1));
        LOGGER.info("Id autoincremental asignado correctamente al registro creado, ID = " + record.getInt(1));
      }
    }
    catch (Exception e) {
      LOGGER.error("No se pudo conectar a la BD => " + e.getMessage());
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        LOGGER.info("Creación exitosa de un nuevo registro, se cierra conexión a BD");
        System.out.println("===== Creación exitosa de un nuevo registro, se cierra conexión a BD =====");
      }
      catch (Exception ex) {
        LOGGER.error("No se pudo cerrar la conexión a la BD => " + ex.getMessage());
        ex.printStackTrace();
      }
    }
    return medicamento;
  }

  // #################### Mesa de Trabajo ####################
  //  Generamos la lógica para buscar un registro por Id
  @Override
  public Medicamento selectById(Integer id) {

    // TODO => Lógica de cómo buscar por Id
    LOGGER.info("Iniciamos la búsqueda(select) de un registro por Id");
    Connection connection = null;

    Medicamento medicamento = null;

    try {
      connection = BD.getConnection();
      LOGGER.info("Conexión exitosa a la BD, se buscará un registro por Id");
      System.out.println("===== Conexión exitosa a la BD, se buscará un registro por Id =====");

      String sqlStatement = "SELECT * FROM MEDICAMENTOS WHERE ID = ?";
      PreparedStatement psSelect = connection.prepareStatement(sqlStatement);
      psSelect.setInt(1, id);

      // Obtenemos el registro generado
      ResultSet record = psSelect.executeQuery();
      LOGGER.info("Ejecución correcta de la búsqueda de un registro por Id");

      // Asignamos los valores del registro encontrado al objeto medicamento previamente inicializado en null
      if(record.next()) {
        LOGGER.info("Registro con el ID = " + id + " fue localizado en la tabla");
        medicamento = new Medicamento(
            record.getString(2),
            record.getString("LABORATORIO"),
            record.getInt(4),
            record.getDouble("precio"),
            record.getInt(6));
        medicamento.setId(id);
      } else {
        LOGGER.warn("Medicamento con el id = " + id + " NO fue localizado en la tabla");
      }
    }
    catch (Exception e) {
      LOGGER.error("No se pudo conectar a la BD => " + e.getMessage());
      e.printStackTrace();
    }
    finally {
      try {
        connection.close();
        LOGGER.info("Consulta exitosa del registro por Id, se cierra conexión a la BD");
        System.out.println("===== Consulta exitosa del registro por Id, se cierra conexión a la BD =====");
      }
      catch (Exception ex) {
        LOGGER.error("No se pudo cerrar la conexión a la BD => " + ex.getMessage());
        ex.printStackTrace();
      }
    }
    return medicamento;
  }
}
