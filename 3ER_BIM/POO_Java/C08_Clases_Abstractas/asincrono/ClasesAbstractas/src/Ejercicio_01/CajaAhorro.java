package Ejercicio_01;

public class CajaAhorro extends Cuenta{
    private Double tasaInteres;

    public CajaAhorro(Cliente cliente, Double saldo, Double tasaInteres) {
        super(cliente, saldo);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void retirar(Double montoRetiro) {
        if(montoRetiro > saldo) {
            System.out.println("Error: Retiro supera saldo en cuenta...");
        } else { saldo -= montoRetiro; }
    }

    public void cobrarIntereses() { saldo = saldo * (1 + tasaInteres); }
}
