package Final_01;

public abstract class OfertaAcademica {
    private String nombre, descripcion;

    public OfertaAcademica(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract double calcularPrecio();

    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "OfertaAcademica{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
