import java.util.List;

public class Carrera extends Oferta{
    private List<Oferta> cursosYTalleres;
    private double costoBasico;

    public Carrera(String nombre, String descripcion, List<Oferta> cursosYTalleres, double costoBasico) {
        super(nombre, descripcion);
        this.cursosYTalleres = cursosYTalleres;
        this.costoBasico = costoBasico;
    }

    public double getPrecio() {
        double precioTotal = costoBasico;
        for (Oferta oferta : cursosYTalleres) {
            precioTotal += oferta.getPrecio();
        }
        return precioTotal;
    }


}
