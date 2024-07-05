package Ejercicio_02_V2;

public class CreadorEmpleadoPH implements CreadorEmpleados {
    @Override
    public Empleado crearEmpleado(String tipoEmpleado) {
        if (tipoEmpleado.equalsIgnoreCase("EMP-PH"))
            return new EmpleadoPH(7.0, 14.0);
        else
            throw new IllegalArgumentException("Tipo de empleado inválido");
    }
}
