import java.time.LocalDate;
import java.util.List;

public interface IBuscador {
  public void buscarVuelosHoteles(String destino, LocalDate salida, List<Vuelo> vuelos, List<Hotel> hoteles);
}
