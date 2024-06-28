package MesaTrabajo;

public class Main {
    public static void main(String[] args) {
        UsuarioJuego jugador_A = new UsuarioJuego("John", "A1B23", 56.31, 5);

        System.out.println("Jugador: " + jugador_A.getNombre());
        System.out.println("Clave: " + jugador_A.getClave());
        System.out.println("Puntaje: " + jugador_A.getPuntaje());
        System.out.println("Nivel: " + jugador_A.getNivel());
        System.out.println("**************************************");
        jugador_A.aumentarPuntaje();
        System.out.println("Puntaje: " + jugador_A.getPuntaje());
        jugador_A.subirNivel();
        System.out.println("Nivel: " + jugador_A.getNivel());
        System.out.println("**************************************");
        jugador_A.bonus(2.5);
        System.out.println("Puntaje: " + jugador_A.getPuntaje());
    }
}
