import dao.BD;
import modelo.Medicamento;
import servicio.MedicamentoService;

public class Main {

  public static void main(String[] args) {

    // Crear un medicamento y lo vamos a persistir
    MedicamentoService medicamentoService = new MedicamentoService();

    // Creación de la tabla
    BD.createTable();

    // Creamos un medicamento
    Medicamento paracetamol = new Medicamento(11, 11, "Paracetamol", "Pfizer", 120.50);

    // Creamos el registro de "paracetamol" en la tabla
    medicamentoService.createRecordService(paracetamol);

    // Mesa de trabajo
    // Buscamos medicamento por Id
    medicamentoService.buscarId(1);
    medicamentoService.buscarId(2);
  }
}