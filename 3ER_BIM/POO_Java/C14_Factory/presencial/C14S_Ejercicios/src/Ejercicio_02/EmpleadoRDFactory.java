package Ejercicio_02;

// Clase "creadora" de un EmpleadoRD mediante la implementación de la interfaz EmpleadoFactory
public class EmpleadoRDFactory implements EmpleadoFactory{
    @Override
    public Empleado crearEmpleado(String empleadoParam) {

        // Aplicar validación si no se hace al crear el objeto
        /*
        if ("EMP-RD".equalsIgnoreCase(empleadoParam))
            return new EmpleadoRD(15000.0);
        else
            throw new IllegalArgumentException("ERROR!!! Tipo de empleado no válido");
         */

        // Sin validación is se hace desde la creación del objeto
        return new EmpleadoRD(15000.0);
    }
}
