package Ejercicio_01;

public class Main {
    public static void main(String[] args) {
        // Lo "normal" sería instanciar directamente de la Clase Session, pero el constructor es privado, por lo que esto no es posible
        // Session session = new Session();

        // En esta caso, vamos a instanciar utilizando el método getInstance(), que valida si la SESSION has sido inicializada o no
        Session session = Session.getInstance();
    }
}
