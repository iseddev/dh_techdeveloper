package Ejercicio_02_V2;

public abstract class Empleado {
    private String nombre, apellido;
    private int legajo;

    public abstract double calcularSueldo(int diasTrabajados);
}
