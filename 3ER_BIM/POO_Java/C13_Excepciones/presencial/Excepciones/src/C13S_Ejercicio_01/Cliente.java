package C13S_Ejercicio_01;

public class Cliente {
    private String nombre, apellido, DNI;
    private double disponible, limite, deuda;

    public Cliente(String nombre, String apellido, String DNI, double limite) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.limite = limite;
        this.disponible = limite;
        this.deuda = 0.0;
    }

    public void comprar(double importeCompra) throws ClienteException{
        if(importeCompra >= disponible) {
            // No se puede comprar, ejecutar Exception
            throw new ClienteException("ERROR!!! Compra de: $" + importeCompra + " supera el límite disponible: $" + disponible);
        }
        deuda += importeCompra;
        disponible -= deuda;
        System.out.println("Compra exitosa por: $" + importeCompra + ", Deuda: $" + deuda + ", Disponible: $" + disponible);
    }

    public void pagarDeuda(double importePago) throws ClienteException{
        if(importePago <= 0) {
            // Lanzar excepción, importePago no debe ser CERO o menor
            throw new ClienteException("ERROR!!! Pago no puede ser CERO o menor");
        }
        if(deuda <= 0) {
            // Lanzar excepción, deuda no debe ser CERO o menor ya que no se tendría deuda por pagar
            throw new ClienteException("ERROR!!! No se puede aplicar pago, deuda es: " + deuda);
        }
        if(importePago > deuda) {
            disponible += importePago;
            System.out.println("Pago por $" + importePago + " a la deuda, Disponible actual: " + disponible);
        }
        deuda -= importePago;
        disponible += importePago;
    }
}
