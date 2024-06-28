import java.util.List;

public class Programa extends Oferta{
    private List<Curso> cursos;
    private double bonificacion;

    public Programa(String nombre, String descripcion, List<Curso> cursos, double bonificacion) {
        super(nombre, descripcion);
        this.cursos = cursos;
        this.bonificacion = bonificacion;
    }
    public double getPrecio(){
        double precioTotal = 0;
        for (Curso curso : cursos) {
            precioTotal += curso.getPrecio();
        }
        return precioTotal * (1 - bonificacion);
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(double bonificacion) {
        this.bonificacion = bonificacion;
    }
}
