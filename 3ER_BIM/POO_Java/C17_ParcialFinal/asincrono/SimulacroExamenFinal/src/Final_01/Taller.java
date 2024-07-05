package Final_01;

import java.util.ArrayList;
import java.util.List;

public class Taller extends OfertaAcademica {

    private List<OfertaAcademica> listaTP;

    public Taller(String nombre, String descripcion) {
        super(nombre, descripcion);
        listaTP = new ArrayList<>();
    }

    public void agregarTrabajoPractico(OfertaAcademica TP) { listaTP.add(TP); }

    @Override
    public double calcularPrecio() {
        double total = 0;
        for (OfertaAcademica TP : listaTP) { total += TP.calcularPrecio(); }
        return total;
    }

    @Override
    public String toString() {
        return "{" +
                "listaTP=" + listaTP +
                '}';
    }
}
