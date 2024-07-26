package PagosConTarjeta;

public class ProcesarCredito extends ProcesarPago{

    @Override
    protected String procesarPago(Tarjeta tarjeta, double monto) {
        String estadoPago = "No se puedo realizar pago";
        if(tarjeta instanceof TarjetaCredito tarjetaCredito) {
            boolean saldoDisponible = haySaldoDisponible(tarjeta, monto);
        }
        return estadoPago;
    }
}
