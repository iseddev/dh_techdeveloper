package Ejercicio_02;

public interface Estado {

    // Estos métodos serán sobre escritos por cada una de las Clases que "hereden"(implementen) esta Interface. En realidad, serán sobre escritos por cada uno de los Estados definidos, en este caso: Hambriento, Triste, Sediento y Feliz
    void darDeComer();
    void darDeBeber();
    void hacerleMimos();
    String comoEstas();

    // La Clase "contexto" (Tamagotchi), llamará a los métodos anteriores independientemente del Estado en el que se encuentre.

    // Método para poder cambiar el estado de nuestro Tamagotchi
    void actualizarTamagotchi(Tamagotchi tamagotchi);
}
