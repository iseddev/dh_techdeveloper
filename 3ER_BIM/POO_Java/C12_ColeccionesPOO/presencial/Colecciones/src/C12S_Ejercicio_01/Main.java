package C12S_Ejercicio_01;

public class Main {
    public static void main(String[] args) {
        Equipo barcelona = new Equipo("Barcelona");

        barcelona.agregarJugador(new Jugador(10, "Ronaldinho", false, true));
        barcelona.agregarJugador(new Jugador(5, "Rafa", false, true));
        barcelona.agregarJugador(new Jugador(25, "Leonel", true, false));
        barcelona.agregarJugador(new Jugador(12, "Roberto", false, false));
        barcelona.agregarJugador(new Jugador(8, "Ronaldo", true, true));
        barcelona.agregarJugador(new Jugador(2, "Piqué", true, true));

        barcelona.mostrarTitulares();
        barcelona.imprimirTitulares();
        barcelona.verTitulares();

        System.out.println("Total titulares lesionados: " + barcelona.totalTitularesLesionados());
    }
}
