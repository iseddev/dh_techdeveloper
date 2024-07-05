package parcial_poo;

import java.util.Date;

public abstract class Paciente {
    private Consulta consulta;
    private Date nacimiento;
    protected String nombre;
    private String apellido;
    private boolean primerConsulta;

    public Paciente(Consulta consulta, Date nacimiento, String nombre, String apellido) {
        this.consulta = consulta;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        primerConsulta = false;
    }

    public void setPrimerConsulta(boolean primerConsulta) {
        this.primerConsulta = primerConsulta;
    }

    public boolean hacerEvaluacionInicial() {
        if(!this.primerConsulta) { return false; }
        return true;
    }
}
