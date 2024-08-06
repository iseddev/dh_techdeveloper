package Presencial01;

public class LiquidadorEfectivo extends Liquidador {

    //Implementacion para calcular el sueldo de un empleado efectivo
    @Override
    protected Double calcularSueldo(Empleado empleado) {

        Double sueldoCalculado = 0d;

        //Validar que el empleado sea un empleado que se le pagará en efectivo
        if (empleado instanceof EmpleadoEfectivo) {
            // Se crea un empleado "efectivo" y se aplica casteo para asegurar que el tipo de empleado
            EmpleadoEfectivo efectivo = (EmpleadoEfectivo)empleado;
            sueldoCalculado = (efectivo.getSueldoBasico() + efectivo.getPremios()) - efectivo.getDescuentos();
        }

        return sueldoCalculado;
    }

    // Al ser un emoleado efectivo, se genera un recibo impreso
    @Override
    protected String generarRecibo(Empleado empleado) { return "documento impreso."; }
}