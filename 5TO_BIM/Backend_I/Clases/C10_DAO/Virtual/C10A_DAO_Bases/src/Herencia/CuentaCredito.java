package Herencia;

public class CuentaCredito extends Cuenta {
  @Override
  public boolean retirar(double monto) {
    setSaldo(getSaldo() - monto);
    return true;
  }
}
