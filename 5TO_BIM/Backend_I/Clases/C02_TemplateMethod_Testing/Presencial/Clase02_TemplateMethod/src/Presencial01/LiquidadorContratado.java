package Presencial01;

public class LiquidadorContratado extends Liquidador {

    @Override
    protected Double calcularSueldo(Empleado empleado) {
        double sueldoCalculado = 0d;
        //Revisar si el empleado recibido sea una instancia de empleado Contratado
        if(empleado instanceof EmpleadoContratado) {
            // Se crea un empleado "efectivo" y se aplica casteo para asegurar que el tipo de empleado
            EmpleadoContratado contratado = (EmpleadoContratado)empleado;
            sueldoCalculado = contratado.getCantidadHoras() * contratado.getValorPorHora();
        }
        return sueldoCalculado;
    }

    // Al ser un emoleado efectivo, se genera un recibo digital
    @Override
    protected String generarRecibo(Empleado empleado) { return "documento digital."; }
}