package Presencial01;

public class LiquidadorEfectivo extends Liquidador {

    //Implementacion para calcular el sueldo de un empleado efectivo
    @Override
    protected Double calcularSueldo(Empleado empleado) {
        Double sueldoCalculado = 0d;
        //Validar que el empleado sea efectivo
        if (empleado instanceof EmpleadoEfectivo) {
            EmpleadoEfectivo efectivo = (EmpleadoEfectivo) empleado;
            sueldoCalculado = (efectivo.getSueldoBasico() + efectivo.getPremios()) - efectivo.getDescuentos();
        }
        return sueldoCalculado;
    }

    @Override
    protected String generarRecibo(Empleado empleado) { return "documento impreso."; }
}