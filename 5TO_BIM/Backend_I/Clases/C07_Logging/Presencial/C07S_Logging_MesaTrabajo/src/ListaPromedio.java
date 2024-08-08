import org.apache.log4j.Logger;
import java.util.List;

public class ListaPromedio {
  private static final Logger LOGGER = Logger.getLogger(ListaPromedio.class);

  public static void procesarLista(List<Integer> listaNums) throws Exception {
    if(listaNums.isEmpty()){
      LOGGER.error("La lista es igual a cero");
      throw new Exception("La lista es igual a cero");
    }

    int listSize=listaNums.size();

    if(listSize>5){ LOGGER.info("La lista es mayor que 5"); }
    if(listSize>10){ LOGGER.info("La lista es mayor que 10"); }

    int suma = 0;
    int max = Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    for (int num : listaNums) {
      suma+=num;
      if(num>max){ max=num; }
      if(num<min){ min=num; }

    }
    double promedio = (double) suma/listSize;
    System.out.println("El promedio es: " + promedio);
    System.out.println("El máximo es: " + max);
    System.out.println("El mínimo es: " + min);
  }
}
