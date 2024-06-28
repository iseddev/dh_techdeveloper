package Ejercicio_01;

public class Embarcacion {
    private Capitan capitan;
    private double precioBase;
    private double valorAdicional;
    private int anioFabricacion;
    private int eslora; // Longitud en metros

    public Embarcacion(Capitan capitan, double precioBase, double valorAdicional, int anioFabricacion, int eslora) {
        this.capitan = capitan;
        this.precioBase = precioBase;
        this.valorAdicional = valorAdicional;
        this.anioFabricacion = anioFabricacion;
        this.eslora = eslora;
    }

    public double calcularAlquiler() {
        if(anioFabricacion > 2020) { precioBase += valorAdicional; }
        return precioBase;
    }
}
