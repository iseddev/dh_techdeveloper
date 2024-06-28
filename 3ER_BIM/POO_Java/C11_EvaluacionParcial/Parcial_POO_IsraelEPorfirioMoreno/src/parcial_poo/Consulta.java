package parcial_poo;

import java.util.Date;

public class Consulta {
    private Date fecha;
    private String especialidad;
    private int hora;
    private int minuto;

    public Consulta(Date fecha, String especialidad, int hora, int minuto) {
        this.fecha = fecha;
        this.especialidad = especialidad;
        this.hora = hora;
        this.minuto = minuto;
    }
}
