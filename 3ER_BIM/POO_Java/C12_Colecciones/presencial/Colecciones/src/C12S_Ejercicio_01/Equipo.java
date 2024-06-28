package C12S_Ejercicio_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipo {
    private String nombre;
    // Hacemos la relación de asociación: Un equipo TIENE MUCHOS jugadores
    // Aplicamos la colección que debamos utilizar, en este caso: List<objectName> nameList
    private List<Jugador> listaJugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        // Esto lo hacemos para que al momento de crear un equipo podamos crear una lista de jugadores
        listaJugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) { listaJugadores.add(jugador); }
    
    public void mostrarTitulares() {
        // Nos apoyamos de una nueva Lista para agregar a los jugadores titulares
        List<Jugador> titularesOrdenados = new ArrayList<>();
        Collections.sort(listaJugadores);
        // Para crear el "forEach", podemos escribir iter, dar TAB y se crea el loop
        for (Jugador jugador : listaJugadores) {
            if(jugador.getEsTitular()) {
                // Agregamos cada jugador titular a la Lista  titularesOrdenados
                titularesOrdenados.add(jugador);
            }
        }
        System.out.println(titularesOrdenados);
    }

    public void imprimirTitulares() {
        List<Jugador> jugadoresTitulares = new ArrayList<>();
        for (Jugador jugador : listaJugadores) {
            if (jugador.getEsTitular()) { jugadoresTitulares.add(jugador); }
        }
        Collections.sort(jugadoresTitulares);
        for (Jugador jugadorTitular : jugadoresTitulares) { System.out.println(jugadorTitular); }
    }

    public void verTitulares() {
        listaJugadores
            .stream() // Acceder a todos los elementos de la lista de forma libre
            .filter(Jugador::getEsTitular) // Filtrar el Objeto por cada "jugador" que es titular
            .sorted() // Comparar cada par de elementos para ir ordenando la lista
            // Imprimir "cada" jugador con los datos que necesitemos
            .forEach(jugador -> System.out.println(jugador.getNombre() + " - " + jugador.getNroCamiseta()));
    }

    public int totalTitularesLesionados() {
        return (int)listaJugadores
            .stream()
            .filter(jugador -> jugador.getEsTitular() && jugador.getEstaLesionado())
            .count();
    }
}