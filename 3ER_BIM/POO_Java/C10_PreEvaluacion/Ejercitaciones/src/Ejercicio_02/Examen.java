package Ejercicio_02;

public class Examen {
    private Alumno alumno;
    private String titulo;
    private String enunciado;
    protected double notaEscrita;

    public Examen(Alumno alumno, String titulo, String enunciado, double notaEscrita) {
        this.alumno = alumno;
        this.titulo = titulo;
        this.enunciado = enunciado;
        this.notaEscrita = notaEscrita;
    }

    public boolean estaAprobado() { return notaEscrita >= 4; }
}
