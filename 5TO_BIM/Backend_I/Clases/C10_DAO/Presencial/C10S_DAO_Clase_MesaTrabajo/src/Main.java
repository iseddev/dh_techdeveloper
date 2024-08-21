import dao.BD;
import model.Medicine;
import service.MedicineService;

public class Main {

  public static void main(String[] args) {

    // Instanciamos un atributo de la Clase MedicamentoService para poder implementar la lógica requerida (que ya existe dentro de MedicamentoService)
    MedicineService medicineService = new MedicineService();

    // Creación de la tabla
    BD.createTable();

    // Creamos un medicamento para poderlo persistir
    Medicine paracetamol = new Medicine("Paracetamol", "Pfizer", 11, 120.50, 11);

    // Insertamos(guardamos) el objeto "paracetamol" como un registro en la tabla
    medicineService.saveMedicine(paracetamol);

    // #################### Mesa de trabajo ####################
    // Buscamos medicamento por Id
    System.out.println("##### Datos del medicamento con ID 1 #####\n" + medicineService.searchById(1));

    medicineService.searchById(2);

    Medicine aspirina = new Medicine("Aspirina", "Bayer", 50,190.20, 32);
    medicineService.saveMedicine(aspirina);
    System.out.println("##### Datos del medicamento con ID 2 #####\n" + medicineService.searchById(2));
  }
}