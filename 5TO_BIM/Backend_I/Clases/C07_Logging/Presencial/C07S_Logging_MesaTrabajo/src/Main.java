import org.apache.log4j.Logger;
import java.util.Arrays;
import java.util.List;

public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class);

  public static void main(String[] args) {

    try{
      List<Integer> lista1= Arrays.asList(1,2,3,4,5,6);
      ListaPromedio.procesarLista(lista1);
      List<Integer> lista2= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);
      ListaPromedio.procesarLista(lista2);
      List<Integer> lista3= List.of();
      ListaPromedio.procesarLista(lista3);
    }catch(Exception e){
      LOGGER.error("Se produjo una excepción: ", e);
    }
  }
}