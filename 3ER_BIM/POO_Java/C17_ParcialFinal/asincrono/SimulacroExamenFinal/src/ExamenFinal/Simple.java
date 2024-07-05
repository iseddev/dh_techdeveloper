package ExamenFinal;

public class Simple extends  Pizza {
    private double precioBase;
    private boolean esEspecial;

    public Simple(String nombre, String descripcion, double precioBase, boolean esEspecial) {
        super(nombre, descripcion);
        this.precioBase = precioBase;
        this.esEspecial = esEspecial;
    }

    @Override
    public double calcularPrecio() {
        if(esEspecial)
            precioBase *= 1.7;
        return precioBase;
    }

    @Override
    public String toString() {
        return "Pizza de " + super.getNombre() + " que tiene un precio base de " + precioBase + " pesos" ;
    }
}
