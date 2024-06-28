package Ejercicio_01;

import java.util.Date;

public class CuentaCorriente extends Cuenta{
    private Double montoAutorizado;

    public CuentaCorriente(Cliente cliente, Double saldo, Double montoAutorizado) {
        super(cliente, saldo);
        this.montoAutorizado = montoAutorizado;
    }

    public void depositar(Double montoDeposito) {
        if(montoDeposito <= 0) {
            System.out.println("Error: Cantidad a depositar no válida...");
        } else { saldo += montoDeposito; }
    }

    @Override
    public void retirar(Double montoRetiro) {
        if(montoRetiro > ( saldo + montoAutorizado)) {
            System.out.println("Error: Retiro supera saldo y monto autorizado en cuenta...");
        } else if(montoRetiro > saldo && montoRetiro <= (saldo + montoAutorizado)) {
            saldo -= montoRetiro;
        } else { saldo -= montoRetiro; }
    }
}
