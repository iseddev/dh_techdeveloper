package Presencial_01;

public class Main {
    public static void main(String[] args) {
        CajaAhorro ahorros01 = new CajaAhorro();
        System.out.println("Saldo ahorros01 = " + ahorros01.saldo);
        ahorros01.depositar(1500.);

        CuentaCorriente corriente01 = new CuentaCorriente();
        System.out.println("Saldo corriente01 = " + corriente01.saldo);
        corriente01.depositar(2800.0);
        corriente01.gravarImpuesto(16);
        corriente01.extraer(2853.0);
        corriente01.extraer(2852.0);
        corriente01.depositar(2800.00);
        corriente01.extraer(2400.0);
    }
}
