import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    // Vuelos
    Vuelo vuelo1 = new Vuelo(
        LocalDate.of(2024, 1, 1),
        LocalDate.of(2024, 1, 8),
        "CDMX",
        "Buenos Aires");

    List<Vuelo> listaVuelos = new ArrayList<>();
    listaVuelos.add(vuelo1);

    // Hoteles
    Hotel hotel1 = new Hotel(
        LocalDate.of(2024,1,1),
        LocalDate.of(2024,1,8),
        "Buenos Aires");

    List<Hotel> listaHoteles = new ArrayList<>();
    listaHoteles.add(hotel1);

    String destino = "Buenos Aires";
    LocalDate entrada = LocalDate.of(2024,1,1);

    Buscador buscadorVueloHotel = new Buscador();
    buscadorVueloHotel.buscarVuelosHoteles(destino, entrada, listaVuelos, listaHoteles);
  }
}
