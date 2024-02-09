package presencial;

public class Gato {
    public static void main(String[] args) {
        String tipoAnimal = "gato";
        String nombre = "Silvestre";
        int aniosEdad = 3;
        double cantidadAlimento = 500;
        String unidadCantidadAlimento = "gramos";
        String sonido = "miau miau";

        System.out.println(nombre + " es un " + tipoAnimal + " y tiene " + aniosEdad + " años de edad");
        System.out.println(nombre + " come " + cantidadAlimento + " " + unidadCantidadAlimento + " y su maullido suena " + sonido );
    }
}
