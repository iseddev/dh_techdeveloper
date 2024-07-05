package Final_01;

import com.sun.management.UnixOperatingSystemMXBean;

public class Curso extends OfertaAcademica {
    private int cargaHorariaMensual, duracionMeses;
    private double precioPorHora;

    public Curso(String nombre, String descripcion, int cargaHorariaMensual, int duracionMeses, double precioPorHora) {
        super(nombre, descripcion);
        this.cargaHorariaMensual = cargaHorariaMensual;
        this.duracionMeses = duracionMeses;
        this.precioPorHora = precioPorHora;
    }

    public int getCargaHorariaMensual() { return cargaHorariaMensual; }

    @Override
    public double calcularPrecio() { return cargaHorariaMensual * duracionMeses * precioPorHora; }

    @Override
    public String toString() {
        return "{" +
                "cargaHorariaMensual=" + cargaHorariaMensual +
                ", duracionMeses=" + duracionMeses +
                ", precioPorHora=" + precioPorHora +
                "}";
    }
}
