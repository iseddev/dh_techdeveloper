package Almacen;

public abstract class Controlador {

    // Atributo que hace referencia a esta misma Clase, pero que será utilizado (mediante el método getter) para pasar el proceso al siguiente verificador en caso de ser necesario
    private Controlador controladorSiguiente;

    public Controlador getControladorSiguiente() { return controladorSiguiente; }
    public void setControladorSiguiente(Controlador controladorSiguiente) {
        this.controladorSiguiente = controladorSiguiente;
    }

    // Método abstracto que implementaran los controladores que "extiendan" de esta Clase para el proceso de verificación de calidad
    public abstract String verificarCalidad(Articulo articulo);
}