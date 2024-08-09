package test;

import model.Odontologo;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoDaoH2Test {


  @Test
  void listarTodos() {
    OdontologoService odontoServ = new OdontologoService();
    Odontologo odonto1 = new Odontologo("Odon1234","Juan","Perez");
    Odontologo odonto2 = new Odontologo("Odon5678","Luisa","Gonzales");

    odontoServ.guardar(odonto1);
    odontoServ.guardar(odonto2);

    assertTrue(odontoServ.listarTodos().size() == 2);
  }
}