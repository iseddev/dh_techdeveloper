import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VueloBuscador {

  private List<Vuelo> listaVuelosDisponibles;

  public VueloBuscador() { this.listaVuelosDisponibles = new ArrayList<>(); }

  public List<Vuelo> getListaVuelosDisponibles() { return listaVuelosDisponibles; }

  public void buscarVuelos(String destino, LocalDate salida, List<Vuelo> vuelos) {
    for (Vuelo vuelo : vuelos) {
      if(vuelo.getDestino().equalsIgnoreCase(destino) && vuelo.getSalida().equals(salida)) {
        listaVuelosDisponibles.add(vuelo);
      }
    }
  }
}