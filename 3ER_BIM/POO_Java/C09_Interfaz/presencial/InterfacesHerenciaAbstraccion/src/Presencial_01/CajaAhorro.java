package Presencial_01;

public class CajaAhorro extends Cuenta{
    // private static final double INTERES_GANADO = 1.2; // static ==> atributo de la Clase y no del objeto instanciado; final ==> "constante"
    private final double INTERES_GANADO = 1.2;

    public void cobrarIntereses() {
        saldo += saldo * (INTERES_GANADO / 100);
    }

    @Override
    public double extraer(double montoRetiro) {
        if(saldo >= montoRetiro) {
            System.out.println("Extraccion exitosa de Caja de Ahorros, Monto: " + montoRetiro + ", Saldo Final: " + saldo);
            saldo -= montoRetiro;
            return saldo;
        } else {
            System.out.println("ERROR!!! Saldo insuficiente");
            return saldo;
        }
    }
}
