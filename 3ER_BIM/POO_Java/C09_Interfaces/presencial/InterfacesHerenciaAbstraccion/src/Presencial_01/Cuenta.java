package Presencial_01;

public abstract class Cuenta {
    protected double saldo; // protected ==> Público para la clase "hija", pero privado para par alas clases que no son hijas
        public abstract double extraer (double montoRetiro);
    public void  depositar(double monto) {
        saldo += monto;
        System.out.println("Deposito exitoso: Monto: " + monto + "; Saldo final: " + saldo);
    }
    public void informacionsaldo() { System.out.println("Saldo actual: " + saldo); }
}