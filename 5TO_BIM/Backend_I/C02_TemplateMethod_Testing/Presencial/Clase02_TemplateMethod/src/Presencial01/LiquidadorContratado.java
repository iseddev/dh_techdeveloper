package Presencial01;

public class LiquidadorContratado extends Liquidador {

    @Override
    protected Double calcularSueldo(Empleado empleado) {
        double sueldoCalculado = 0d;
        //Revisar si el empleado recibido sea una instancia de empleado Contratado
        if(empleado instanceof EmpleadoContratado) {
            EmpleadoContratado contratado = (EmpleadoContratado)empleado;
            sueldoCalculado = contratado.getCantidadHoras() * contratado.getValorPorHora();
        }
        return sueldoCalculado;
    }

    @Override
    protected String generarRecibo(Empleado empleado) { return "documento digital."; }
}