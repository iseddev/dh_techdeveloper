package Ejercicio_01;

import java.util.Date;

public abstract class Cuenta {
    private Cliente cliente;
    protected Double saldo;

    public Cuenta(Cliente cliente, Double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }


    public void depositar(Double montoDeposito){
        if(montoDeposito <= 0) {
            System.out.println("Error: Cantidad a depositar no válida...");
        } else {
            saldo += montoDeposito;
            System.out.println("Detalles efectivo depositado:");
            System.out.println("Cantidad: " + montoDeposito);
        }
    }

    public void depositar(Double montoDeposito, String banco, Date fecha) {
        if(montoDeposito <= 0) {
            System.out.println("Error: Cantidad a depositar no válida...");
        } else {
            saldo += montoDeposito;
            System.out.println("Detalles cheque dspositado:");
            System.out.println("Banco emisor: " + banco);
            System.out.println("Fecha de pago: " + fecha);
            System.out.println("Monto depositado: " + montoDeposito);
        }
    }
    public void retirar(Double montoRetiro){}
    public Double informarSaldo() { return saldo; }

}
