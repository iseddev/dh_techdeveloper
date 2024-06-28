package Ejercicio_01;

public class Tamagotchi {
    private Estado estadoActual; // Necesitamos una relación de ASOCIACIÓN: Tamagotchi tiene un Estado => estadoActual

    public Tamagotchi() { // Constructor
        // Es el estado inicial que plantea el reto
        estadoActual = new EstaHambriento();
    }


    // Puede determinarse el estado por el propio usuario al momento de crear la instancia
    // public Tamagotchi(Estado estadoActual) { this.estadoActual = esatdo Actual }


    // Definición de la lógica a implementar dependiendo de las acciones(métodos) ejecutadas y hacer los cambios de estado requeridos
    public void darDeBeber() {
        estadoActual.darDeBeber();
        if (estadoActual instanceof EstaSediento) {
            estadoActual = new EstaFeliz();
        } else if (estadoActual instanceof EstaFeliz) {
            estadoActual = new EstaHambriento();
        } else if (estadoActual instanceof EstaTriste) {
            // Sigue en el mismo estado: TRISTE
        } else {
            estadoActual = new EstaTriste();
        }
    }

    public void darDeComer() {
        estadoActual.darDeComer();
        if (estadoActual instanceof EstaHambriento) {
            estadoActual = new EstaFeliz();
        } else if (estadoActual instanceof EstaTriste) {
            // Sigue en el mismo estado: TRISTE
        } else if (estadoActual instanceof EstaSediento) {
            estadoActual = new EstaTriste();
        } else {
            estadoActual = new EstaSediento();
        }
    }

    public void hacerleMimos() {
        estadoActual.hacerleMimos();
        if (estadoActual instanceof EstaTriste) {
            estadoActual = new EstaFeliz();
        } else if (estadoActual instanceof EstaFeliz) {
            // Sigue en el mismo estado: FELIZ
        } else if (estadoActual instanceof EstaHambriento) {
            // Sigue en el mismo estado: HAMBRIENTO
        } else { // Sigue en el mismo estado: SEDIENTO }
        }
    }


    public Estado getEstadoActual() {
        return estadoActual;
    }

    // Actualizamos el estado de nuestra Clase, se aplicará el estado determinado por la lógica anterior
    public void setEstadoActual(Estado estadoActual) { this.estadoActual = estadoActual; }
}