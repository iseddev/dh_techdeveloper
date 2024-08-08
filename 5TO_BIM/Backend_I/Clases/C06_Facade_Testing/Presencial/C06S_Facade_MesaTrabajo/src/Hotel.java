import java.time.LocalDate;

public class Hotel {

  private LocalDate entrada, salida;
  private String ciudad;

  public Hotel(LocalDate entrada, LocalDate salida, String ciudad) {
    this.entrada = entrada;
    this.salida = salida;
    this.ciudad = ciudad;
  }

  public LocalDate getEntrada() { return entrada; }
  public LocalDate getSalida() { return salida; }
  public String getCiudad() { return ciudad; }
}
