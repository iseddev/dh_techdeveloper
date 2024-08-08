package Musicfy;

import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {
    private String nombre;
    private List<Cancion> listaCanciones;

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.listaCanciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        if (!listaCanciones.contains(cancion)) {
            listaCanciones.add(cancion);
            System.out.println("AGREGADA: " + cancion.getNombre());
        } else { System.out.println("ERROR AL AGREGAR" + cancion.getNombre()); }
    }

    public void eliminarCancion(Cancion cancion) {
        if (listaCanciones.contains(cancion)) {
            listaCanciones.remove(cancion);
            System.out.println("ELIMINADA: " + cancion.getNombre());
        } else {
            System.out.println("ERROR AL ELIMINAR: " + cancion.getNombre());
        }
    }

    public String getNombre() { return nombre; }

    public void getListaCanciones() {
        for (Cancion cancion : listaCanciones) {
            System.out.println("Canción: " + cancion.getNombre() + " - " + cancion.getArtista() + " - " + cancion .getGenero());
        }
    }
}