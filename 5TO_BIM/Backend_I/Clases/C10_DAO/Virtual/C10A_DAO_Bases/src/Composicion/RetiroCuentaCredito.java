package Composicion;

public class RetiroCuentaCredito implements IRetiroCuenta {

  @Override
  public boolean gestionarRetiro(Cuenta cuenta, double monto) {
    cuenta.setSaldo(cuenta.getSaldo() - monto);
    return true;
  }
}
