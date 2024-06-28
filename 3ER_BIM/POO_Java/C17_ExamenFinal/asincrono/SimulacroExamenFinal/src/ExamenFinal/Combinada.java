package ExamenFinal;

import java.util.ArrayList;
import java.util.List;

public class Combinada extends Pizza {
    List<Simple> pizzas;

    public Combinada(String nombre, String descripcion) {
        super(nombre, descripcion);
        pizzas = new ArrayList<>();
    }

    public void agregarPizza(Simple pizza) { pizzas.add(pizza); }

    @Override
    public double calcularPrecio() {
        double precioUno = pizzas.get(0).calcularPrecio();
        double precioDos = pizzas.get(1).calcularPrecio();
        if(precioUno > precioDos)
            return precioUno;
        else
            return precioDos;
    }

    @Override
    public String toString() {
        return "Pizza Combinada " + super.getNombre() + ", que es la mitad " + pizzas.get(0).getNombre() + " y mitad " + pizzas.get(1).getNombre() + " cuyo cálculo de precio nos arroja " + this.calcularPrecio();
    }
}