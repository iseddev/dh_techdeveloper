package Ejercicio_02;

public class Parcial extends Examen{
    private int numeroUnidad;
    protected int numeroReintentos;

    public Parcial(Alumno alumno, String titulo, String enunciado, double notaEscrita, int numeroUnidad, int numeroReintentos) {
        super(alumno, titulo, enunciado, notaEscrita);
        this.numeroUnidad = numeroUnidad;
        this.numeroReintentos = numeroReintentos;
    }

    public boolean puedeRecuperar() {
        int intentosA = 3;
        int intentosB = 2;
        if(numeroUnidad <= 3 ) { return numeroReintentos <= intentosA; }
        else { return numeroReintentos <= intentosB; }
    }
}
