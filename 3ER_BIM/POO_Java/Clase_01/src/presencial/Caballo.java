package presencial;

public class Caballo {
    public static void main(String[] args) {
        int cantidadAnimales = 1;
        String tipoAnimal = "caballo";
        String nombre = "Braulio";
        String color = "blanco";
        String trabajo = "tirar de un carro";
        String raza = "criollo";
        double gastoAlimentacionSemanal = 1250.40;
        int aniosTenencia = 2;


        System.out.println("El granjero tiene " + cantidadAnimales + " " + tipoAnimal + " " + raza + " de color " + color + ", llamado " + nombre + " que tiene desde hace " + aniosTenencia + " años. Lo utiliza para " + trabajo + " y gasta " + gastoAlimentacionSemanal + " en su alimentacion semanal.");
    }
}
