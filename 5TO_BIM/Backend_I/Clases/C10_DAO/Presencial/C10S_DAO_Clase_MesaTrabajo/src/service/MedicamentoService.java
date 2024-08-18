package service;

import dao.IDAO;
import dao.implementation.MedicamentoImplDAOH2;
import model.Medicamento;

public class MedicamentoService {

  // Instanciamos de la interfaz IDAO un medicamento de tipo Medicamento para hacer uso de los métodos implementados en IDAO
  private final IDAO<Medicamento> medicamentoIDao;

  // Constructor
  public MedicamentoService() { this.medicamentoIDao = new MedicamentoImplDAOH2(); }

  // Método_ para crear un registro en la BD
  public Medicamento insertMedicamento(Medicamento medicamento) {
    return medicamentoIDao.insert(medicamento);
  }

  // #################### Mesa de trabajo ####################
  public Medicamento selectById(Integer id) {
    return medicamentoIDao.selectById(id);
  }
}