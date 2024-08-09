import dao.DataBase;
import model.Odontologo;
import service.OdontologoService;

public class Main {
  public static void main(String[] args) {

    OdontologoService oService = new OdontologoService();
    DataBase.createTable();
    Odontologo odonto1 = new Odontologo("Odon1234","Juan","Perez");
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
