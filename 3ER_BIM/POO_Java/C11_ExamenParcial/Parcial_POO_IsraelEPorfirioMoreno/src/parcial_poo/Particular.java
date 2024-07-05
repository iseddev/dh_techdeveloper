package parcial_poo;

import java.util.Date;

public class Particular  extends Paciente{
    private Double costoConsulta;
    private String DNI;

    public Particular(Consulta consulta, Date nacimiento, String nombre, String apellido, Double costoConsulta, String DNI) {
        super(consulta, nacimiento, nombre, apellido);
        this.costoConsulta = costoConsulta;
        this.DNI = DNI;
    }
}
