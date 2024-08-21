package service;

import dao.IDao;
import dao.implementation.MedicineImplH2;
import model.Medicine;

// ***** Implementación de la lógica del negocio. Aquí definimos la implementación de persistencia que se utilizará para el manejo de los datos. En este caso se hará uso de las implementaciones(lógica) definidas en MedicamentoImplH2.java que desarrolla los procesos necesarios para la persistencia de datos en una base de datos H2. *****

public class MedicineService {

  // Instanciamos una interfaz de Idao que nos ayudará a utilizar la lógica de negocio definida pero con las implementaciones desarrolladas en MedicamentoImplH2.java para un objeto Medicamento.
  private final IDao<Medicine> medicamentoIDao;

  // Constructor
  // En este caso, establecemos la implementación que deberá utilizar nuestro atributo medicamentoIdao, que para este caso, será una implmentación de persistencia de datos en una Bd H2.
  public MedicineService() { this.medicamentoIDao = new MedicineImplH2(); }

  // Este método_ es el que utilizaremos para llevar acabo la operación de guardar(insertar) un registro en una tabla. No es necesario que tenga el mismo nombre que el método_ definido en la interface, pero puede ser así.
  // Método_ para crear un registro en la BD
  public Medicine saveMedicine(Medicine medicine) {
    return medicamentoIDao.insertRecord(medicine);
  }


  // #################### Mesa de trabajo ####################
  // Éste método_ es el que utilizaremos para llevar a cabo la operación de búsqueda por id de un registro en la BD.
  public Medicine searchById(Integer id) {
    return medicamentoIDao.selectById(id);
  }
}