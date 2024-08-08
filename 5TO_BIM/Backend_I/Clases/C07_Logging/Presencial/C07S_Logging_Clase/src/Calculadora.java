import org.apache.log4j.Logger;

public class Calculadora {

  private static final Logger LOGGER = Logger.getLogger(Calculadora.class);

  public static void main(String[] args) {
    Division division = new Division();

    try {
      LOGGER.info("LOGGER: Ejecución del programa principal");
      double cociente = division.calcularDivision(10d, 0d);
    } catch (Exception e) {
      LOGGER.error("LOGGER: Se produjo un error: " + e.getMessage());
      System.out.println("Se produjp un error: " + e.getMessage());
    }

    try {
      LOGGER.info("LOGGER: Ejecución del programa principal");
      double cociente = division.calcularDivision(10d, 2d);
    } catch (Exception e) {
      LOGGER.error("LOGGER: Se produjo un error: " + e.getMessage());
      System.out.println("Se produjp un error: " + e.getMessage());
    }
  }
}