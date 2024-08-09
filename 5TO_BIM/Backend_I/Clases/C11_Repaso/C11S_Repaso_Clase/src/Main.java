import dao.BD;
import modelo.Paciente;
import servicio.PacienteServicio;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    BD.crearTabla(); // La tabla se va a crear una sola vez

    Paciente paciente1 = new Paciente("Erica","Mar", "Colombia", "123", LocalDate.of(2024,03,03));

    PacienteServicio servicio = new PacienteServicio();

    servicio.insertarRegistro(paciente1);

    System.out.println("Este es el paciente original");
    System.out.println(paciente1.toString());

    paciente1.setNombre("Daniela");
    servicio.updateRegistro(paciente1);

    System.out.println("Este es el paciente modificado");
    System.out.println(paciente1.toString());

    Paciente paciente2 = new Paciente("Bruno", "Apellido", "Colombia", "123", LocalDate.of(2024,03,03));

    Paciente paciente3 = new Paciente("Israel", "Apellido", "Colombia", "123", LocalDate.of(2024,03,03));

    servicio.insertarRegistro(paciente2);
    servicio.insertarRegistro(paciente3);

    servicio.consultarTodos();
  }
}
