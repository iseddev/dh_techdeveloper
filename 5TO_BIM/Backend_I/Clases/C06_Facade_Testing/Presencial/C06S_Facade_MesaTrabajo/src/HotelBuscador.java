import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelBuscador {

  private List<Hotel> listaHotelesDisponibles;

  public HotelBuscador() { this.listaHotelesDisponibles = new ArrayList<>();  }

  public List<Hotel> getListaHotelesDisponibles() { return listaHotelesDisponibles; }

  public void buscarHoteles(String destino, LocalDate entrada, List<Hotel> hoteles) {
    for (Hotel hotel : hoteles) {
      if (hotel.getCiudad().equalsIgnoreCase(destino) && hotel.getEntrada().equals(entrada)) {
        listaHotelesDisponibles.add(hotel);
      }
    }
  }
}