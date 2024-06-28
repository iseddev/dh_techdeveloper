package Ejercicio_01;

public class Main {
    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi();
        System.out.println("Acciones ejecutadas en nuestro Tamagotchi");
        System.out.println("Estado inicial: " + tamagotchi.getEstadoActual());
        tamagotchi.darDeComer();
        tamagotchi.darDeComer();
        tamagotchi.darDeComer();
        tamagotchi.darDeBeber();
        tamagotchi.hacerleMimos();
        tamagotchi.hacerleMimos();
        tamagotchi.darDeComer();
        tamagotchi.darDeBeber();
        System.out.println("Estado actual: " + tamagotchi.getEstadoActual());
    }
}