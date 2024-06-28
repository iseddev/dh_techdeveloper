package MesaTrabajo_01;

public class Caballo {
    public static void main(String[] args) {
        String color = "blanco";
        int aniosAntiguedad = 2;
        String trabajo = "tirar de un carro";
        String nombre = "Braulio";
        Double costoComidaSemanal = 1250.40;
        String raza = "Criolla";

        System.out.println(nombre + " es un caballo de color " + color + " de raza " + raza + ".");
        System.out.println("Su dueño lo tiene desde hace " + aniosAntiguedad + " años y le sirve para " + trabajo + ".");
        System.out.println("Su dueño gasta $" + costoComidaSemanal + " MXN a la semana para alimentarlo.");
    }
}
