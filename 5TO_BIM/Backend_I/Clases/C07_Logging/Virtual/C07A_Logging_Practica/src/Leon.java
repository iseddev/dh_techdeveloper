import org.apache.log4j.Logger;

public class Leon {

  private final  static Logger LOGGER = Logger.getLogger(Leon.class);

  private String nombre;
  private int edad;
  private boolean esAlfa;

  public Leon(String nombre, int edad, boolean esAlfa) {
    this.nombre = nombre;
    this.edad = edad;
    this.esAlfa = esAlfa;
  }

  public String getNombre() { return nombre; }
  public int getEdad() { return edad; }
  public boolean getEsAlfa() { return esAlfa; }

  public void setNombre(String nombre) { this.nombre = nombre; }
  public void setEdad(int edad) { this.edad = edad; }
  public void setEsAlfa(boolean esAlfa) { this.esAlfa = esAlfa; }

  public void correr() { LOGGER.info("El León " + this.nombre + " está corriendo"); }

  public static void esMayorA10(String nombre, int edad, boolean esAlfa) throws Exception {
    if (edad < 0) {
      LOGGER.error("La edad no puede ser negativa");
      throw new Exception("La edad del León " + nombre + " es incorrecta");
//      throw new Exception();
    } else if (edad > 10 && esAlfa){
      LOGGER.info("El León " + nombre + " tiene más de 10 años y es un León ALFA");
    }
  }
}
