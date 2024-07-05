package Ejercicio_02;

public class EmpleadoPH extends Empleado {
    private double importeHora, retencionImpuesto;

    public EmpleadoPH(double importeHora, double retencionImpuesto) {
        this.importeHora = importeHora;
        this.retencionImpuesto = retencionImpuesto;
    }

    @Override
    public double calcularSueldo(int dias) {
        return (importeHora * dias) - retencionImpuesto;
    }
}
