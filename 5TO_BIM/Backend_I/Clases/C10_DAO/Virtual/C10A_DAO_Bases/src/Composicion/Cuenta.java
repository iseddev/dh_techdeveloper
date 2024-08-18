package Composicion;

public class Cuenta {

  private Integer numero;
  private double saldo;
  // Este atributo nos ayudará a gestionar los retiros, ya que es una instancia de IGestionarRetiro
  private IRetiroCuenta gestionRetiro;

  public Integer getNumero() {
    return numero;
  }
  public double getSaldo() {
    return saldo;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }
  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }
  public void setGestionRetiro(IRetiroCuenta gestionRetiro) { this.gestionRetiro = gestionRetiro; }

  // Éste método_ hará la función de retiro pero implementando a gestionarRetiro() de la Interface IGestionRetiro
  public boolean retirar(double monto) {
    return gestionRetiro.gestionarRetiro(this, monto);
  }
}
