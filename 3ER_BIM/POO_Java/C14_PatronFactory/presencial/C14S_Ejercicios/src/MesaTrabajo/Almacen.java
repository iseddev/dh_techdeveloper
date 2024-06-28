package MesaTrabajo;

import java.util.ArrayList;
import java.util.List;

public class Almacen {

    // Creamos un atributo listaProductos (List de tipo Producto) donde almacenaremos los productos creados
    private List<Producto> listaProductos;

    // Constructor
    public Almacen () {
        // Inicializamos la lista que contendrá nuestros productos que iremos creando y agregando
        this.listaProductos = new ArrayList<>();
    }

    // Método que usaremos para agregar los productos creados al la listaProductos del Almacen
    public void agregarProducto (Producto producto) { listaProductos.add(producto); }

    // Método para calcular el espacio requerido de acuerdo al volumen (espacio) calculado en cada objeto creado
    public double calcularEspacioRequerido() {
        double espacioRequerido = 0.0;
        //Recorremos cada producto existente en listaProductos
        for (Producto producto : listaProductos) {
            // Acumulamos cada volumen obtenido mediante el método calcularEspacio() de cada objeto en la Lista
            espacioRequerido += producto.calcularEspacio();
        }
        return espacioRequerido;
    }

    public List<Producto> getListaProductos() { return listaProductos; }
}