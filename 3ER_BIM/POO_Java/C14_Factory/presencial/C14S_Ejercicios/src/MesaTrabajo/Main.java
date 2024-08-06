package MesaTrabajo;

public class Main {
    public static void main(String[] args) {
        System.out.println("********** Creando Productos **********");

        // Creamos la "fabrica", que es una instancia de la Clase "ProductoFactory".
        ProductoFactory fabrica = new ProductoFactory();

        // Utilizando la instanciación anterior para crear cada producto
        Producto pelota01 = fabrica.crearProducto("pelotafutbol");
        Producto pelota02 = fabrica.crearProducto("pelotatenis");
        Producto caja01 = fabrica.crearProducto("CAJA10X10");

        // Usando directamente ProductoFactory
        Producto pelota03 = ProductoFactory.crearProducto("pelotaFUTBOL");
        Producto pelota04 = ProductoFactory.crearProducto("PELOTAtenis");
        Producto caja02 = ProductoFactory.crearProducto("caja10X10");

        System.out.println("********** ALMACÉN **********");

        // Creamos un Objeto Almacen
        Almacen almacen = new Almacen();

        // Agregamos los productos previamente creados
        almacen.agregarProducto(pelota01);
        almacen.agregarProducto(pelota02);
        almacen.agregarProducto(pelota03);
        almacen.agregarProducto(pelota04);
        almacen.agregarProducto(caja01);
        almacen.agregarProducto(caja02);
        // Agregamos productos directamente con el "fabricador" de productos
        almacen.agregarProducto(ProductoFactory.crearProducto("pelotaFUTBOL"));
        almacen.agregarProducto(ProductoFactory.crearProducto("PELOTAtenis"));
        almacen.agregarProducto(ProductoFactory.crearProducto("CaJa10x10"));

        // Mostramos por consola la lista de productos almacenados
        for (Object producto : almacen.getListaProductos()) { System.out.println(producto); }

        // Mostramos por consola el espacio requerido para almacenar los productos agregados anteriormente
        System.out.println("Espacio de almacenamiento requerido: " + almacen.calcularEspacioRequerido() + " cm3");
    }
}
