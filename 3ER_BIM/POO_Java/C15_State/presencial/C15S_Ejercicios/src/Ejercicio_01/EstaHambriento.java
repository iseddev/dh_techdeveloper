package Ejercicio_01;

public class EstaHambriento extends Estado {
    @Override
    public void darDeComer() {
        System.out.println("Estado HAMBRIENTO, se le da de comer, cambió a estado FELIZ...");
    }

    @Override
    public void darDeBeber() {
        System.out.println("Estado HAMBRIENTO, se le da de beber, cambió a estado TRISTE...");
    }

    @Override
    public void hacerleMimos() {
        System.out.println("Estado HAMBRIENTO, se le HACEN MIMOS, sigue en estado HAMBRIENTO...");
    }

    @Override
    public String toString() { return "EstaHambriento"; }
}
