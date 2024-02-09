package presencial;

public class Pez {
    public static void main(String[] args) {
        String tipoAnimal = "pez";
        String nombre = "Nemo";
        int aniosEdad = 1;
        double cantidadAlimento = 140;
        String unidadCantidadAlimento = "gramos";
        String sonido = "blurp blurp";

        System.out.println(nombre + " es un " + tipoAnimal + " y tiene " + aniosEdad + " año de edad");
        System.out.println(nombre + " come " + cantidadAlimento + " " + unidadCantidadAlimento + " y el sonido de sus burbujas hacen " + sonido );
    }
}
