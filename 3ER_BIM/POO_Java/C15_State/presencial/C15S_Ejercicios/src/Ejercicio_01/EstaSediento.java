package Ejercicio_01;

public class EstaSediento extends Estado {
    @Override
    public void darDeComer() {
        System.out.println("Estado SEDIENTO, se le da de comer, cambió a estado TRISTE...");
    }

    @Override
    public void darDeBeber() {
        System.out.println("Estado SEDIENTO, se le da de beber, cambió a estado FELIZ...");
    }

    @Override
    public void hacerleMimos() {
        System.out.println("Estado SEDIENTO, se le hacen mimos, sigue estando SEDIENTO...");
    }

    @Override
    public String toString() { return "EstaSediento"; }
}
