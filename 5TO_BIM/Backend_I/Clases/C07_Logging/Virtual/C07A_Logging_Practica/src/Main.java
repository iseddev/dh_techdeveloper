import org.apache.log4j.Logger;

public class Main {

  private final static Logger LOGGER = Logger.getLogger(Main.class);


  public static void main(String[] args) {

    try {
//      Leon mufasa = new Leon("Mufasa", 12, true);
//      Leon simba = new Leon("Simba", -5, false);

//      mufasa.correr();
//      mufasa.esMayorA10(mufasa.getNombre(), mufasa.getEdad(), mufasa.getEsAlfa());
//      simba.correr();
//      simba.esMayorA10(simba.getNombre(), simba.getEdad(), simba.getEsAlfa());

//      Tigre tony = new Tigre("Tony", 12);
      Tigre pepe = new Tigre("Pepe", -2);

//      tony.correr();
//      tony.esMayorA10(tony.getNombre(), tony.getEdad());
      pepe.correr();
      pepe.esMayorA10(pepe.getNombre(), pepe.getEdad());
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
    }
  }
}
