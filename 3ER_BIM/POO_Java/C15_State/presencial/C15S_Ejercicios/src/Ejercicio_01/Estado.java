package Ejercicio_01;

// Esta clase abstracta (puede ser también una interface) es la que determinará las acciones que tienen que (SI o SI) implementar cada estado posible
public abstract class Estado {
    public abstract void darDeComer();
    public abstract void darDeBeber();
    public abstract void hacerleMimos();
}
