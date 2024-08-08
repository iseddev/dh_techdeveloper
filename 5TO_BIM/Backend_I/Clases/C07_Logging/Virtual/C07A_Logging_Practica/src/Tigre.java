import org.apache.log4j.Logger;

public class Tigre {

  private final static Logger LOGGER = Logger.getLogger(Tigre.class);

  private String nombre;
  private int edad;

  public Tigre(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  public String getNombre() { return nombre; }
  public int getEdad() { return edad; }

  public void setNombre(String nombre) { this.nombre = nombre; }
  public void setEdad(int edad) { this.edad = edad; }

  public void correr() {
    LOGGER.info("El Tigre " + this.nombre + " está corriendo");
  }

  public static void esMayorA10(String nombre, int edad) throws Exception {
    if (edad < 0) {
      LOGGER.error("La edad no puede ser negativa");
      throw new Exception("La edad del Tigre " + nombre + " es incorrecta");
    }
  }
}
