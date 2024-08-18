package Composicion;

public class RetiroCuentaAhorro implements IRetiroCuenta {

  @Override
  public boolean gestionarRetiro(Cuenta cuenta, double monto) {
    boolean retiroEsPermitido = false;
    if(cuenta.getSaldo() >= monto) {
      retiroEsPermitido = true;
      cuenta.setSaldo(cuenta.getSaldo() - monto);
    }
    return retiroEsPermitido;
  }
}