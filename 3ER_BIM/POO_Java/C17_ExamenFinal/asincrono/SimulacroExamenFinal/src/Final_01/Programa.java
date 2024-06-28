package Final_01;

import java.util.ArrayList;
import java.util.List;

public class Programa extends OfertaAcademica {
    private double bonificacion;

    private List<OfertaAcademica> listaCursos;
    public Programa(String nombre, String descripcion, double bonificacion) {
        super(nombre, descripcion);
        this.bonificacion = bonificacion;
        listaCursos = new ArrayList<>();
    }

    public void agregarOferta(OfertaAcademica curso) { listaCursos.add(curso); }

    @Override
    public double calcularPrecio() {
        double total = 0;
        for (OfertaAcademica curso : listaCursos)
            total += curso.calcularPrecio();
        return total * (1 - (bonificacion / 100));
    }

    @Override
    public String toString() {
        return "{" +
                "bonificacion=" + bonificacion +
                ", listaCursos=" + listaCursos +
                '}';
    }
}
