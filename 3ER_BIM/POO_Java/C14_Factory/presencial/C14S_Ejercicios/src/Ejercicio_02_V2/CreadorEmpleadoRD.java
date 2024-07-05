package Ejercicio_02_V2;

public class CreadorEmpleadoRD implements CreadorEmpleados {
    @Override
    public Empleado crearEmpleado(String tipoEmpleado) {
        if(tipoEmpleado.equalsIgnoreCase("EMP-RD"))
            return new EmpleadoRD(1000);
        else
            throw new IllegalArgumentException("Tipo de empleado inválido");
    }
}
