package Final_01;

import java.util.ArrayList;
import java.util.List;

public class Carrera extends OfertaAcademica {
    private double costoBasico;
    private List<OfertaAcademica> listaCursos;
    private List<OfertaAcademica> listaTalleres;

    public Carrera(String nombre, String descripcion, double costoBasico) {
        super(nombre, descripcion);
        this.costoBasico = costoBasico;
        listaCursos = new ArrayList<>();
        listaTalleres = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        if(curso.getCargaHorariaMensual() > 10)
            listaCursos.add(curso);
    }

    public void agregarTaller(Taller taller) { listaTalleres.add(taller); }

    @Override
    public double calcularPrecio() {
        double totalCursos = 0;
        double totalTalleres = 0;
        for (OfertaAcademica curso : listaCursos) {
            totalCursos += curso.calcularPrecio();
        }
        for (OfertaAcademica taller : listaTalleres) {
            totalTalleres += taller.calcularPrecio();
        }
        return costoBasico + totalCursos + totalTalleres;
    }
}
