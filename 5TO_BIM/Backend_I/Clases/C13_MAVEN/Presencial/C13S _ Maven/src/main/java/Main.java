import dao.BD;
import modelo.Paciente;
import servicio.PacienteServicio;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {

    BD.createTable(); // La tabla se va a crear una sola vez

    // Instanciamos un servicio para la persistencia de los pacientes
    PacienteServicio servicioPaciente = new PacienteServicio();

    Paciente paciente = new Paciente("Erica", "Mar", "Colombia", "123", LocalDate.of(2024,3,3));
    servicioPaciente.guardar(paciente);

    System.out.println("Este es el paciente original");
    System.out.println(paciente);

    paciente.setNombre("Daniela");
    servicioPaciente.actualizar(paciente);

    System.out.println("Este es el paciente modificado");
    System.out.println(paciente);

    Paciente paciente2 = new Paciente("Bruno", "Mars", "Colombia", "123", LocalDate.of(2024,3,3));

    Paciente paciente3 = new Paciente("Israel", "Porfirio", "Colombia", "123", LocalDate.of(2024,3,3));

    servicioPaciente.guardar(paciente2);
    servicioPaciente.guardar(paciente3);

    servicioPaciente.listarTodos();
  }
}