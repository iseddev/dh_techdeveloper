package ejercicio_1;

public class EmpleadoTemporal extends Empleado{
    private Double costoPorHora;
    private int cantidadHoras;

    public EmpleadoTemporal(String nombre, int numeroEmpleado, Double costoPorHora, int cantidadHoras) {
        super(nombre, numeroEmpleado);
        this.costoPorHora = costoPorHora;
        this.cantidadHoras = cantidadHoras;
    }

    // Para sobre escribir este método (que viene de Empleado), es necesario que devuelva el mismo tipo de dato (o no) y que el tipo y número de parámetros sea el mismo, entonces es que podemos aplicar la directiva @Override
    @Override
    public Double calcularSalario() {
        return cantidadHoras * costoPorHora;
    }
}
