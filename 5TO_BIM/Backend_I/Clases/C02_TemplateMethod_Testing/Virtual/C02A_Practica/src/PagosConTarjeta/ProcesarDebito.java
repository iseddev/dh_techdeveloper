package PagosConTarjeta;

public class ProcesarDebito extends  ProcesarPago {

    @Override
    protected String procesarPago(Tarjeta tarjeta, double monto) {
        boolean saldoSuficiente = haySaldoDisponible(tarjeta, monto);

    }
}
