package Ejercicio_01;

// Por ahora, se esta utilizando a Automovil como CLase principal, pero por convención, esta clase debe nombrarse como Main
public class Automovil {

    public static void main(String[] args) {
        String brand = "Ford";
        char firstBrandChar = brand.charAt(0); // .chartA(i) busca el caracter en la posición (0, 1, 2, ...) indicada dentro del paréntesis
        int doors = 4; // Tipo de dato primitivo
        Integer manufactureYear = 2020; // Integer => Clase envolvente, contiene métodos utilizables
        // El uso de int vs Integer depende de las necesidades de nuestro programa
        double weight = 1200.00;
        Double tankCapacity = 45.00;

        // Mostrar por pantalla => System.out.println();
        System.out.println("********** Bienvenidos **********");
        System.out.println("Auto seleccionado: " + brand);
        System.out.println("Letra inicial: " + firstBrandChar);
        System.out.println("Cantidad de puertas: " + doors);
        System.out.println("Año fabricación: " + manufactureYear);
        System.out.println("Peso: " + weight + "kg");
        System.out.println("Capacidad del tanque de combustible: " + tankCapacity + " litros");
    }
}
