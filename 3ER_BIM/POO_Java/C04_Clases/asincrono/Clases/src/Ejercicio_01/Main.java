package Ejercicio_01;

public class Main {
    public static void main(String[] args) {
        Articulo item_01 = new Articulo("Tijeras", 35.90, 25);

        System.out.println("Artículo: " + item_01.getDescripcion());
        System.out.println("Precio de venta: " + item_01.getPrecioVenta());
        System.out.println("Total inventario: " + item_01.getStock());
        System.out.println("Hay stock?: " + item_01.hayStock());
    }
}
