package Almacen;

public class Articulo {
    private String nombre, envasado;
    private int lote, peso;

    // Constructor
    public Articulo(String nombre, String envasado, int lote, int peso) {
        this.nombre = nombre;
        this.envasado = envasado;
        this.lote = lote;
        this.peso = peso;
    }

    // Sólo se generan getters
    public String getNombre() { return nombre; }
    public String getEnvasado() { return envasado; }
    public int getLote() { return lote; }
    public int getPeso() { return peso; }
}
