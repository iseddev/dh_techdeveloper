package Herencia;

public abstract class Cuenta {
  private Integer numero;
  private double saldo;

  public Integer getNumero() { return numero; }
  public void setNumero(Integer numero) { this.numero = numero; }

  public double getSaldo() { return saldo; }
  public void setSaldo(double saldo) { this.saldo = saldo; }

  public abstract boolean retirar(double monto);
}