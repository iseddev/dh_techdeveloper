import dao.BD;
import model.Paciente;
import service.PacienteServicio;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {

    BD.crearTabla(); // La tabla se va a crear una sola vez
    PacienteServicio servicio = new PacienteServicio();

    Paciente erica = new Paciente( "Erica", "Mar", "Colombia", "EM123", LocalDate.of(2024,03,03));
    servicio.insertRegistro(erica);

    System.out.println(">>>>> Este es el paciente original <<<<<");
    System.out.println(erica);

    erica.setNombre("Daniela");
    servicio.updateRegistro(erica);
    System.out.println(">>>>> Este es el paciente actualizado <<<<<");
    System.out.println(erica);

    Paciente bruno = new Paciente("Bruno", "Mars", "Colombia", "BM123", LocalDate.of(2024,03,03));
    servicio.insertRegistro(bruno);

    Paciente john = new Paciente("John", "Doe", "USA", "JD123", LocalDate.of(2024,03,03));
    servicio.insertRegistro(john);

    System.out.println(servicio.selectTodos());
    System.out.println(servicio.selectPorId(2));

    Paciente elena = new Paciente("Elena", "Doe", "USA", "ED123", LocalDate.of(2022, 05, 10));
    servicio.insertRegistro(elena);

    System.out.println(servicio.selectPorId(4));
    servicio.deletePorId(2);
    System.out.println(servicio.selectTodos());

    elena.setDomicilio("JPN");
    elena.setApellido("Smith");
    servicio.updateRegistro(elena);
    System.out.println(servicio.selectPorId(4));
  }
}