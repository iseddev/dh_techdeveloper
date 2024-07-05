package Ejercicio_02;

public class Main {
    public static void main(String[] args) {

        // Este tamagotchi ya tiene asignado por defecto el estado Hambriento, ya que así se definió en la Clase Tamagotchi
        Tamagotchi tamagotchi = new Tamagotchi();

        System.out.println(tamagotchi.comoEstas());
        tamagotchi.darDeComer();
        tamagotchi.darDeComer();
        tamagotchi.darDeComer();
        System.out.println(tamagotchi.comoEstas());
        tamagotchi.hacerleMimos();
        tamagotchi.hacerleMimos();
        tamagotchi.darDeBeber();
        tamagotchi.darDeBeber();
        System.out.println(tamagotchi.comoEstas());
        tamagotchi.hacerleMimos();
    }
}