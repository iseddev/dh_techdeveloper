package PagosConTarjeta;

public class TarjetaDebito extends Tarjeta {

    private double saldodisponible;

    public TarjetaDebito(String numeroFrontal, int codigoSeguridad, String fechaExpiracion, double saldodisponible) {
        super(numeroFrontal, codigoSeguridad, fechaExpiracion);
        this.saldodisponible = saldodisponible;
    }

    public double getSaldodisponible() { return saldodisponible; }
    public void setSaldodisponible(double saldodisponible) { this.saldodisponible = saldodisponible; }
}
