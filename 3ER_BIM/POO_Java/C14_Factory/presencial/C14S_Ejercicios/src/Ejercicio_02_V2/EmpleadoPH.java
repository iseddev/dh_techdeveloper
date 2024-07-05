package Ejercicio_02_V2;

public class EmpleadoPH extends Empleado {
    private double sueldoHora, retencionImpuesto;

    public EmpleadoPH(double sueldoHora, double retencionImpuesto) {
        this.sueldoHora = sueldoHora;
        this.retencionImpuesto = retencionImpuesto;
    }

    @Override
    public double calcularSueldo(int diasTrabajados) {
        return sueldoHora * 8 * diasTrabajados * (1 - (retencionImpuesto / 100));
    }
}
