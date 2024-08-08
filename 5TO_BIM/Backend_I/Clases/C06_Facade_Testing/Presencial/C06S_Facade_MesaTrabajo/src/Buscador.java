import java.time.LocalDate;
import java.util.List;

public class Buscador implements IBuscador {

  public Buscador() {}

  static void mostrarResultados(VueloBuscador vueloBuscador, HotelBuscador hotelBuscador) {
    System.out.println(">>>>> Resultados de los Vuelos y Hoteles encontrados <<<<<");
    for (Vuelo vuelo : vueloBuscador.getListaVuelosDisponibles()) {
      System.out.println("===== Vuelo =====\n"
          + "Destino: " + vuelo.getDestino()
          + "\nSalida: " + vuelo.getSalida());
    }
    for (Hotel hotel : hotelBuscador.getListaHotelesDisponibles()) {
      System.out.println("===== Hotel =====\n"
      + "Ciudad: " + hotel.getCiudad()
      + "\nEntrada: " + hotel.getEntrada());
    }
  }

  @Override
  public void buscarVuelosHoteles(String destino, LocalDate salida, List<Vuelo> vuelos, List<Hotel> hoteles) {

    VueloBuscador vueloBuscador = new VueloBuscador();
    HotelBuscador hotelBuscador = new HotelBuscador();

    vueloBuscador.buscarVuelos(destino, salida, vuelos);
    hotelBuscador.buscarHoteles(destino, salida, hoteles);

    mostrarResultados(vueloBuscador, hotelBuscador);
  }
}