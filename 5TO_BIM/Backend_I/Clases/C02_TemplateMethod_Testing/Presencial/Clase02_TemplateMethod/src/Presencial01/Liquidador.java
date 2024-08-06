package Presencial01;

public abstract class Liquidador {

    public String liquidarSueldo(Empleado empleado){

        String respuesta = "La liquidación no pudo ser calculada";

        // 1. Calcular sueldo =>
        Double sueldoCalculado = calcularSueldo(empleado);

        if(sueldoCalculado > 0) {
            // 2. Generar recibo
            String tipoRecibo = generarRecibo(empleado);
            // 3. Depositar sueldo
            String sueldoDepositado = despositarSueldo(empleado);

            respuesta = "La liquidación generada es un " + tipoRecibo + " Saldo a liquidar: " + sueldoCalculado;
        }


        return respuesta;
    }

    // ##### Métodos para cumplir con los pasos solicitados => Calcular sueldo, Generar recibo y Depositar sueldo #####

    // protected nos ayuda a implementar si o sí este método en las instancias que se hagan de esta clase
    protected abstract Double calcularSueldo(Empleado empleado);
    protected abstract String generarRecibo(Empleado empleado);
    private String despositarSueldo(Empleado empleado) {
        return "Se depositó el sueldo de "+ empleado.getNombre() + ", a la cuenta " + empleado.getNumeroDeCuenta();
    }
}