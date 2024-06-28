package ejercicio_1;

public abstract class Empleado {
    private String nombre;
    private int numeroEmpleado;

    public Empleado(String nombre, int numeroEmpleado) {
        this.nombre = nombre;
        this.numeroEmpleado = numeroEmpleado;
    }

    public abstract Double calcularSalario();
}
