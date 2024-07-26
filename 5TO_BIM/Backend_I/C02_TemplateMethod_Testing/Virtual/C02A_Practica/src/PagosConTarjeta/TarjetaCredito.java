package PagosConTarjeta;

public class TarjetaCredito extends Tarjeta {

    private double limiteCredito, saldoUtilizado;

    public TarjetaCredito(String numeroFrontal, int codigoSeguridad, String fechaExpiracion, double limiteCredito, double saldoUtilizado) {
        super(numeroFrontal, codigoSeguridad, fechaExpiracion);
        this.limiteCredito = limiteCredito;
        this.saldoUtilizado = saldoUtilizado;
    }

    public double getLimiteCredito() { return limiteCredito; }
    public void setLimiteCredito(double limiteCredito) { this.limiteCredito = limiteCredito; }

    public double getSaldoUtilizado() { return saldoUtilizado; }
    public void setSaldoUtilizado(double saldoUtilizado) { this.saldoUtilizado = saldoUtilizado; }
}
