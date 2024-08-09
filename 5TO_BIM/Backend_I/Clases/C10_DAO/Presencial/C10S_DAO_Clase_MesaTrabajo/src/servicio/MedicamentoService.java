package servicio;

import dao.IDAO;
import dao.implementacion.LogicaCRUD;
import modelo.Medicamento;

public class MedicamentoService {

  // Instanciamos de la interfaz IDAO un medicamento de tipo Medicamento para hacer uso de los métodos implementados en IDAO
  private IDAO<Medicamento> medicamentoService;

  // Constructor
  public MedicamentoService() { this.medicamentoService = new LogicaCRUD(); }

  // Método para crear un registro en la BD
  public Medicamento createRecordService(Medicamento medicamento) {
    return medicamentoService.guardarRegistro(medicamento);
  }

  // Mesa de trabajo
  public Medicamento buscarId(Integer id) {
    return medicamentoService.buscarPorId(id);
  }
}