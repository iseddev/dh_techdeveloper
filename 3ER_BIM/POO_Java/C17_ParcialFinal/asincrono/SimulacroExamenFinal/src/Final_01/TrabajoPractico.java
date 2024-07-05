package Final_01;

public class TrabajoPractico extends OfertaAcademica{
    private double costo;

    public TrabajoPractico(String nombre, String descripcion, double costo) {
        super(nombre, descripcion);
        this.costo = costo;
    }

    @Override
    public double calcularPrecio() { return costo; }

    @Override
    public String toString() {
        return "{" +
                "costo=" + costo +
                '}';
    }
}
