package C12S_Ejercicio_01;

public class Jugador implements Comparable<Jugador>{
    private int nroCamiseta;
    private String nombre;
    private boolean estaLesionado;
    private boolean esTitular;

    public Jugador(int nroCamiseta, String nombre, boolean estaLesionado, boolean esTitular) {
        this.nroCamiseta = nroCamiseta;
        this.nombre = nombre;
        this.estaLesionado = estaLesionado;
        this.esTitular = esTitular;
    }

    public int getNroCamiseta() { return nroCamiseta; }
    public String getNombre() { return nombre; }
    public boolean getEstaLesionado() { return estaLesionado; }
    public boolean getEsTitular() { return esTitular; }

    @Override
    public int compareTo(Jugador otroJugador) {
        // Comparamos los números de camisetas de los jugadores
        return Integer.compare(nroCamiseta, otroJugador.getNroCamiseta());
    }

    @Override
    // Utilizamos .toString() para mostrar los datos de cada jugador
    public String toString() {
        return "Jugador{" +
                "nroCamiseta=" + nroCamiseta +
                ", nombre='" + nombre + '\'' +
                ", estaLesionado=" + estaLesionado +
                ", esTitular=" + esTitular +
                '}';
    }
}
