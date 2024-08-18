package Herencia;

public class CuentaAhorro extends Cuenta {
  @Override
  public boolean retirar(double monto) {
    boolean retiroEsPermitido = false;
    if(getSaldo() >= monto) {
      retiroEsPermitido = true;
      setSaldo(getSaldo() - monto);
    }
    return retiroEsPermitido;
  }
}
