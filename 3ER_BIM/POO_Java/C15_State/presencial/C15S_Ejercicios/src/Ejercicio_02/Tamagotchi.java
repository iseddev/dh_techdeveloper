package Ejercicio_02;

// Esta Clase es nuestro "contexto", es decir, es la clase que recibe como parámetro una Interface o Clase Abstracta (en este caso vamos a utilizar la Interface Estado), de aquí es donde vamos a recibir los estados definidos para ayudar a actualizar el comportamiento de nuestra instancia (objeto)
public class Tamagotchi {

    // Atributo de "tipo" Estado para definir el estado en el que se encuentra.
    private Estado estado;

    // Método para establecer el estado de nuestro Tamagotchi
    public void establecerEstado(Estado estado){
        this.estado = estado;
        this.estado.actualizarTamagotchi(this);
    }

    // Constructor, en este caso inicializamos el estado en Hambriento
    public Tamagotchi() { establecerEstado(new Hambriento()); }

    // Creamos todas las acciones que nuestra Clase puede ejecutar (están definidas en la Interface o Clase Abstracta) y dependiendo de esto, es como se comportará, ya que cada Estado, definirá el comportamiento establecido
    public void darDeComer() { this.estado.darDeComer(); }
    public void darDeBeber() { this.estado.darDeBeber(); }
    public void hacerleMimos() { this.estado.hacerleMimos(); }
    public String comoEstas() { return this.estado.comoEstas(); }
}
