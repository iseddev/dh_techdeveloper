package presencial;

public class Perro {
    public static void main(String[] args) {
        String tipoAnimal = "perro";
        String nombre = "Manchitas";
        int aniosEdad = 2;
        double cantidadAlimento = 1.5;
        String unidadCantidadAlimento = "kilogramos";
        String sonido = "guau guau";

        System.out.println(nombre + " es un " + tipoAnimal + " y tiene " + aniosEdad + " años de edad");
        System.out.println(nombre + " come " + cantidadAlimento + " " + unidadCantidadAlimento + " al día y hace " + sonido );
    }
}
