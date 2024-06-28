package Ejercicio_02;

public class EmpleadoPHFactory implements EmpleadoFactory{
    @Override
    public Empleado crearEmpleado(String empleadoParam) {
        if ("EMP-PH".equalsIgnoreCase(empleadoParam))
            return new EmpleadoPH(150.0, 15);
        else
            throw new IllegalArgumentException("ERROR!!! Tipo de empleado no válido");
    }
}
