package Ejercicio_02;

public class Final extends Examen{
    private double notaOral;
    private  String descripcionTema;

    public Final(Alumno alumno, String titulo, String enunciado, double notaEscrita, double notaOral, String descripcionTema) {
        super(alumno, titulo, enunciado, notaEscrita);
        this.notaOral = notaOral;
        this.descripcionTema = descripcionTema;
    }

    public boolean esMayor(Final otroFinal) { return (notaEscrita + notaOral) / 2 > (otroFinal.notaEscrita + otroFinal.notaOral) / 2; }
}
