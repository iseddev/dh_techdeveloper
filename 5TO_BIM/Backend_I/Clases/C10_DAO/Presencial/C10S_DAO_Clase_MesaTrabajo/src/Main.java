import dao.BD;
import model.Medicamento;
import service.MedicamentoService;

public class Main {

  public static void main(String[] args) {

    // Instanciamos un atributo de la Clase MedicamentoService para poder implementar la lógica requerida (que ya existe dentro de MedicamentoService)
    MedicamentoService service = new MedicamentoService();

    // Creación de la tabla
    BD.createTable();

    // Creamos un medicamento para poderlo persistir
    Medicamento paracetamol = new Medicamento("Paracetamol", "Pfizer", 11, 120.50, 11);

    // Insertamos(guardamos) el objeto "paracetamol" como un registro en la tabla
    service.insertMedicamento(paracetamol);

    // #################### Mesa de trabajo ####################
    // Buscamos medicamento por Id
    System.out.println("##### Datos del medicamento con ID 1 #####\n" + service.selectById(1));

    service.selectById(2);

    Medicamento aspirina = new Medicamento("Aspirina", "Bayer", 50,190.20, 32);
    service.insertMedicamento(aspirina);
    System.out.println("##### Datos del medicamento con ID 2 #####\n" + service.selectById(2));
  }
}