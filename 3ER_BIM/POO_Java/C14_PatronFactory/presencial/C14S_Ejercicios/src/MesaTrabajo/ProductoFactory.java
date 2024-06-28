package MesaTrabajo;

// Esta Clase es la que nos sirve como "intermediaria" y fuente de creación de instancias a cada producto que vayamos a crear
public class ProductoFactory {

    // Este método es el que contiene la lógica para crear un producto en específico, dependiendo del tipo de producto ingresado como parámetro; "caja10x10", "pelotafutbol" o "pelotatenis"...

    // static nos ayuda a instanciar este método desde la propia Clase, ya no es necesario instanciar la clase para acceder a este método
    public static Producto crearProducto(String tipoProducto){
        if (tipoProducto.equalsIgnoreCase("PELOTAFUTBOL"))
            return new Pelota(11);
        else if (tipoProducto.equalsIgnoreCase("PELOTATENIS"))
            return new Pelota(0.32);
        else if(tipoProducto.equalsIgnoreCase("CAJA10X10"))
            return new Caja(10, 10, 10);
        else
            System.err.println("Error en tipo de producto solicitado");
        return null;
    }
}
