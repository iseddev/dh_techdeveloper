import dao.BD;
import modelo.Paciente;
import servicio.PacienteServicio;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {

    BD.crearTabla(); // La tabla se va a crear una sola vez

    Paciente erica = new Paciente(
        "Erica",
        "Mar",
        "Colombia",
        "123",
        LocalDate.of(2024,03,03));

    PacienteServicio servicio = new PacienteServicio();

    servicio.insertarRegistro(erica);

    System.out.println("Este es el paciente original");
    System.out.println(erica);

    erica.setNombre("Daniela");
    servicio.updateRegistro(erica);

    System.out.println("Este es el paciente modificado");
    System.out.println(erica);

    Paciente bruno = new Paciente("Bruno", "Apellido", "Colombia", "123", LocalDate.of(2024,03,03));
    servicio.insertarRegistro(bruno);

    Paciente israel = new Paciente("Israel", "Apellido", "Colombia", "123", LocalDate.of(2024,03,03));
    servicio.insertarRegistro(israel);

    servicio.consultarTodos();

    servicio.consultarPorId(2);

    servicio.eliminarPaciente(2);

    servicio.consultarTodos();

    Paciente john = new Paciente("John", "Doe", "USA", "JD123", LocalDate.of(2022, 05, 10));
    servicio.insertarRegistro(john);
    servicio.consultarPorId(2);
    servicio.consultarPorId(4);
    servicio.eliminarPaciente(2);
  }
}
