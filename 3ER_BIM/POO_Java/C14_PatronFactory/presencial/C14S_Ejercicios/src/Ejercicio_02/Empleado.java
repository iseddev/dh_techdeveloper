package Ejercicio_02;

// Al ser una Clase ABSTRACTA no es necesario crear un constructor
// Esta clase es nuestro "molde general" de los atributos y métodos que tendrá un objeto instanciado de Empleado
public abstract class Empleado {
    private String nombre, apellido;
    private int legajo;

    // Método abstracto calcularSueldo()
    public abstract double calcularSueldo(int diasTrabajados);
}