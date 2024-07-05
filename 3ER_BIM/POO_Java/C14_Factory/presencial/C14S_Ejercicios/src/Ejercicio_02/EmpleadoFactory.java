package Ejercicio_02;

// El patron Factory sugiere hacer uso de una interface para la "construcción" de nuestros objetos
public interface EmpleadoFactory {

    // Se crea un método (por defecto e implícito) abstracto del tipo Empleado
    Empleado crearEmpleado(String tipoEmpleado);

    // Lo anterior es lo mismo que:
    // public abstract Empleado crearEmpleado(String tipoEmpleado);
}
