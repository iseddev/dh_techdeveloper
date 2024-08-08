import java.time.LocalDate;

public class Vuelo {

  private LocalDate salida, regreso;
  private String origen, destino;

  public Vuelo(LocalDate salida, LocalDate regreso, String origen, String destino) {
    this.salida = salida;
    this.regreso = regreso;
    this.origen = origen;
    this.destino = destino;
  }

  public LocalDate getSalida() { return salida; }
  public LocalDate getRegreso() { return regreso; }
  public String getOrigen() { return origen; }
  public String getDestino() { return destino; }
}
