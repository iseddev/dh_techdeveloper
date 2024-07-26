package Gobierno;

public class Documento {
    private String contenido;
    private Integer tipo;

    public Documento(String contenido, Integer tipo) {
        this.contenido = contenido;
        this.tipo = tipo;
    }

    public String getContenido() { return contenido; }
    public Integer getTipo() { return tipo; }
}