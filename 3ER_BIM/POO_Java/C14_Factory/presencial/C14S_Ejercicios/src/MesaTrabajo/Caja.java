package MesaTrabajo;

// Esta Clase implementa la estructura definida en Producto, en este caso, sólo el método calcularEspacio()
public class Caja implements Producto{

    // Atributos propios de la Clase Caja
    private double longitud, ancho, altura;

    // Constructor para instanciar a esta Clase
    public Caja(double longitud, double ancho, double altura) {
        this.longitud = longitud;
        this.ancho = ancho;
        this.altura = altura;
    }

    // Sobre escritura del método calcularEspacio() implementado desde la interfaz Producto con la lógica propia para calcular el volúmen de un cubo (caja)
    @Override
    public double calcularEspacio() { return longitud * ancho * altura; }

    @Override
    public String toString() {
        return "Caja{" +
                "longitud=" + longitud +
                ", ancho=" + ancho +
                ", altura=" + altura +
                '}';
    }
}