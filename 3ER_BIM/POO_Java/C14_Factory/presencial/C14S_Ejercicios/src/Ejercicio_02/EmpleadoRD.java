package Ejercicio_02;

public class EmpleadoRD extends Empleado {
    private double sueldoMensual;

    public EmpleadoRD(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSueldo(int diasTrabajados) { return (sueldoMensual / 30) * diasTrabajados; }
}