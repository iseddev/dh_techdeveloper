package Ejercicio_01;

public class EstaTriste extends Estado {
    @Override
    public void darDeComer() {
        System.out.println("Estado TRISTE, se le da de comer: Beep Beep, Tamagotchi vomitando!!!");
    }

    @Override
    public void darDeBeber() {
        System.out.println("Estado TRISTE, se le da de beber: Beep Beep Beep, display titilando...");
    }

    @Override
    public void hacerleMimos() {
        System.out.println("Estado TRISTE, se le hacen mimos: cambió a estado FELIZ");
    }

    @Override
    public String toString() { return "EstaTriste"; }
}
