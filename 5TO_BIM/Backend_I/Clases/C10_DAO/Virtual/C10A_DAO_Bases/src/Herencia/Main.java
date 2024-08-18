package Herencia;

public class Main {
  public static void main(String[] args) {
    // ========== CUENTA DE AHORRO ==========
    Cuenta ahorro1 = new CuentaAhorro();
    ahorro1.setSaldo(1000d);
    System.out.println("Saldo inicial em cuenta de ahorro1: " + ahorro1.getSaldo());
    ahorro1.retirar(200d); // Un comportamiento del método_ retirar() para ahorro1
    System.out.println("Saldo después de retirar $200.00: " + ahorro1.getSaldo());


    Cuenta credito1 = new CuentaCredito();
    credito1.setSaldo(1000d);
    System.out.println("Saldo inicial em cuenta de credito1: " + credito1.getSaldo());
    credito1.retirar(1100d); // Otro comportamiento del método_ retirar() para crédito1
    System.out.println("Saldo después de retirar $1,100.00: " + credito1.getSaldo());

    // Por ende, se dice que el método_ retirar() es un método_ *polimórfico* (Polimorfismo)

    // Ahora vamos a cambiar la instancia de ahorro1 a una CuentaCredito
    // ahorro1 = new CuentaCredito(); // Esto "reseteará" todos los atributos previamente establecidos
    // System.out.println(ahorro1.getSaldo());

    // Si deseamos que ahorro1 mantenga los valores de sus atributos, lo podemos hacer "referenciando" a otra cuenta qoe esté instanciada a una CuentaCredito a la que le vamos a pasar los valores de los atributos de ahorro1
    Cuenta credito2 = new CuentaCredito();
    credito2.setSaldo(ahorro1.getSaldo());
    ahorro1 = credito2;
    System.out.println(ahorro1.getSaldo());
    // Lo antetiot es demasiado "engorroso". Una solución es cambiar la relación de Herencia en una relación de Composición
  }
}