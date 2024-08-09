package test;

import model.Odontologo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoDao2Test {

  @Test
  void listarTodos() {
    OdontologoService odontoServ = new OdontologoService();
    Odontologo odonto1 = new Odontologo("Odon1234","Juan","Perez");
    Odontologo odonto2 = new Odontologo("Odon5678","Luisa","Gonzales");
    Odontologo odonto3 = new Odontologo("Odon9123","Fernando","Chavez");
    Odontologo odonto4 = new Odontologo("Odon4567","Ana","Gutierrez");

    odontoServ.guardarModo2(odonto1);
    odontoServ.guardarModo2(odonto2);
    odontoServ.guardarModo2(odonto3);
    odontoServ.guardarModo2(odonto4);
    assertTrue(odontoServ.listarTodos2().size() == 4);

  }
}