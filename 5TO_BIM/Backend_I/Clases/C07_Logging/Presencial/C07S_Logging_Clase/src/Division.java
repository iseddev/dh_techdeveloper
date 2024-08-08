import org.apache.log4j.Logger;

public class Division {

  // Agregamos la variable private final static LOGGER para el uso de la librería log4j
  private final static Logger LOGGER = Logger.getLogger(Division.class);

  public double calcularDivision(double numerador, double denominador) {
    LOGGER.info("LOGGER: Se inicia el método calcularDivisión de la Clase Division");
    if (denominador == 0d) {
      LOGGER.warn("LOGGER: Se está intentando dividir entre CERO...");
      throw new ArithmeticException("ArithmeticException => No es posible hacer una división entre CERO!!!");
    }

    LOGGER.info("LOGGER: Se reliza la división exitosamente");
    return numerador / denominador;
  }
}