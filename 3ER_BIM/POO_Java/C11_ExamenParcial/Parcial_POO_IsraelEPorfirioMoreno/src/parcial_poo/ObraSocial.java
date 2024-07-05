package parcial_poo;

import java.util.Date;

public class ObraSocial extends Paciente implements Comparable<ObraSocial>{
    private String nombreObraSocial;
    private int numeroAsociado;

    public ObraSocial(Consulta consulta, Date nacimiento, String nombre, String apellido, String nombreObraSocial, int numeroAsociado) {
        super(consulta, nacimiento, nombre, apellido);
        this.nombreObraSocial = nombreObraSocial;
        this.numeroAsociado = numeroAsociado;
    }

    public int getNumeroAsociado() { return numeroAsociado; }

    @Override
    public int compareTo(ObraSocial o) {
        int resultado = 0;
        if(this.numeroAsociado > o.getNumeroAsociado()) {
            System.out.println(nombre + ", No. asociado " + numeroAsociado + " es MAYOR que " + o.nombre + ", No. asociado " + o.numeroAsociado);
            resultado = 1;
        } else if(this.numeroAsociado < o.getNumeroAsociado()) {
            System.out.println(o.nombre + ", No. asociado " + o.numeroAsociado + " es MAYOR que " + nombre + ", No. asociado " + numeroAsociado);
            resultado = -1;
        }
        return resultado;
    }
}
