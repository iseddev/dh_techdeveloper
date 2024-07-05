package Ejercicio_01;

public class EstaFeliz extends Estado {

    // Definir lo que sucede cuando está feliz y se lleva a cabo alguna acción: beber, comer, mimos

    @Override
    public void darDeBeber() {
        // Pasa a un estado EstaHambriento
        System.out.println("Estado FELIZ, se le da de beber, cambió a estado HAMBRIENTO...");
    }
    @Override
    public void darDeComer() {
        System.out.println("Estado FELIZ, se le da de comer, cambió a estado SEDIENTO...");
    }
    @Override
    public void hacerleMimos() {
        System.out.println("Estado FELIZ, se le hacen mimos, sigue en estado FELIZ...");
    }

    @Override
    public String toString() { return "EstaFeliz"; }
}
