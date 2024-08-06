package MesaTrabajo;

// Esta Clase implementa la estructura definida en Producto, en este caso, sólo el método calcularEspacio()
public class Pelota implements Producto{

    // Atributos propios de la Clase Pelota
    private double radio;

    // Constructor para instanciar a esta Clase
    public Pelota(double radio) { this.radio = radio; }

    // Sobre escritura del método calcularEspacio() implementado desde la interfaz Producto con la lógica propia para calcular el volúmen de una esfera (balón)
    @Override
    public double calcularEspacio() { return 4 * Math.PI * Math.pow(radio, 3) / 3; }

    @Override
    public String toString() {
        return "Pelota{" +
                "radio=" + radio +
                '}';
    }
}