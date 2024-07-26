package PagosConTarjeta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public abstract class ProcesarPago {

    public boolean haySaldoDisponible(Tarjeta tarjeta, double monto) {
        boolean saldoSuficiente = false;
        if(tarjeta instanceof TarjetaDebito) {
            TarjetaDebito debito = (TarjetaDebito)tarjeta;
            saldoSuficiente = monto <= debito.getSaldodisponible();
            return saldoSuficiente;
        } else if(tarjeta instanceof TarjetaCredito) {
            TarjetaCredito credito = (TarjetaCredito) tarjeta;
            saldoSuficiente = (credito.getSaldoUtilizado() + monto) < credito.getLimiteCredito();
            return saldoSuficiente;
        }
        return false;
    };

    public boolean esVencimientoCorrecto(Tarjeta tarjeta) {
        int mesExpiracion = tarjeta.getMesExpiracion();
        int anioExpiracion = tarjeta.getAnioExpiracion();
        LocalDate fechaExpiracion = LocalDate.of(anioExpiracion, mesExpiracion, 1);
        Period hastaVencimiento = LocalDate.now().until(fechaExpiracion);
        return false;
    }

    protected abstract String procesarPago(Tarjeta tarjeta, double monto);
}