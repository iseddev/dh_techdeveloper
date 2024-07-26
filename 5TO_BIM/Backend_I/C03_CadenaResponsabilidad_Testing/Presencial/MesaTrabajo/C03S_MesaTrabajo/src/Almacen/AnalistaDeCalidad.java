package Almacen;

// Esta clase puede considerarse como la Clase Main, pero la utilizaremos para realizar los Tests Unitarios
public class AnalistaDeCalidad {

    // Este atributo será el que usaremos para iniciar la cadena
    private Controlador analizarPorLote;

    // Método para analizar los artículos que utiliza esta propia Clase
    public String analizarCalidad(Articulo articulo) {
        // Retornamos el resultado de la verificación por LOTE
        return analizarPorLote.verificarCalidad(articulo);
    }

    // Método para analizar la calidad de los productos y donde se lleva a cabo la lógica para el proceso en "cadena"
    public AnalistaDeCalidad() {

        // ##### Creamos los verificadores que utilizaremos, en este caso, 3 #####
        // Creamos los Controladores(verificadores) que utilizaremos
        analizarPorLote = new VerificadorLote();
        Controlador analizarPorPeso = new VerificadorPeso();
        Controlador analizarPorEnvase = new VerificadorEnvase();

        // Armamos cadena de procesamiento
        analizarPorLote.setControladorSiguiente(analizarPorPeso);
        analizarPorPeso.setControladorSiguiente(analizarPorEnvase);
    }
}
