import odontologo.dao.BD_Odontologo;
import odontologo.model.Odontologo;
import odontologo.service.OdontologoService;
import paciente.dao.BD_Paciente;
import paciente.modelo.Paciente;
import paciente.servicio.PacienteServicio;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {

    // ##########################################################
    // #################### SECCION PACIENTE ####################
    // ##########################################################

    System.out.println("#################### SECCION PACIENTE ####################");
    BD_Paciente.crearTabla(); // La tabla se va a crear una sola vez

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

    // ############################################################
    // #################### SECCION ODONTÓLOGO ####################
    // ############################################################
    System.out.println("#################### SECCION ODONTÓLOGO ####################");
    OdontologoService oService = new OdontologoService();
    BD_Odontologo.createTable();
    Odontologo odonto1 = new Odontologo("Odon1234", "Juan", "Perez");
    Odontologo odonto2 = new Odontologo("Odon5678","Luisa","Gonzales");
    Odontologo odonto3 = new Odontologo("Odon9123","Fernando","Chavez");
    Odontologo odonto4 = new Odontologo("Odon4567","Ana","Gutierrez");

    oService.guardar(odonto1);
    oService.guardar(odonto2);
    oService.guardar(odonto3);
    oService.guardar(odonto4);

    oService.listarTodos();

    oService.guardarModo2(odonto1);
    oService.guardarModo2(odonto2);
    oService.guardarModo2(odonto3);
    oService.guardarModo2(odonto4);
    oService.listarTodos2();
  }
}
