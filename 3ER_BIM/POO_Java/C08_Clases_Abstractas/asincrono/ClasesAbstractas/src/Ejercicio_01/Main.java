package Ejercicio_01;

public class Main {
    public static void main(String[] args) {
        System.out.println("******************** Caja de Ahorro ********************");
        Cliente cliente_01 = new Cliente(123, "Sanchez", "1A23B", "ABC001");
        CajaAhorro cajaAhorro = new CajaAhorro(cliente_01, 2000.0, .01);
        cajaAhorro.depositar(1500.0);
        System.out.println("Saldo: " + cajaAhorro.informarSaldo());
        cajaAhorro.retirar(3501.0);
        cajaAhorro.retirar(3000.0);
        System.out.println("Saldo: " + cajaAhorro.informarSaldo());
        System.out.println("******************** Cuenta Corriente ********************");
        CuentaCorriente cuentaCorriente = new CuentaCorriente(cliente_01, 5000.0, 2000.00);
        System.out.println("Saldo: " + cuentaCorriente.informarSaldo());
        cuentaCorriente.depositar(2000.00);
        System.out.println("Saldo: " + cuentaCorriente.informarSaldo());
        System.out.println("Retiro superior al saldo y monto autorizado");
        cuentaCorriente.retirar(9001.0);
        System.out.println("Retiro superior al saldo disponible");
        cuentaCorriente.retirar(8000.0);
        // cajaAhorro.retirar(3000.0);
    }
}
