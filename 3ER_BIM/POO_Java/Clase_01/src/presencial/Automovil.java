package presencial;

public class Automovil {
    public static void main(String[] args) {
        String marca = "Ford";
        char inicial = marca.charAt(0);
        int cantidadDePuertas = 4; // variable primitiva
        int anioDeFabricacion = 2024; /* Clase envolvente */
        double capacidad = 400.40; // variable primitiva
        double capacidadCombustible = 40.50; /* Clase envolvente */

        System.out.println("***** Bienvenidos *****"); // sout
        System.out.println("Auto seleccionado: " + marca + ", Inicial de la marca: " + inicial + ", Año de fabricación: " + anioDeFabricacion + ", Capacidad de combustible: " + capacidadCombustible);
    }
}