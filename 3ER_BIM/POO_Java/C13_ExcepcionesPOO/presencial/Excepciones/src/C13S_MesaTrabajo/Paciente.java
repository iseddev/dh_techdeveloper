package C13S_MesaTrabajo;

import java.util.Date;

public class Paciente {
    String nombre, apellido, DNI;
    Date fechaInternacion, fechaAlta;

    Paciente(String nombre, String apellido, String DNI, Date fechaInternacion) throws PacienteException {
        Date hoy = new Date();
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        fechaAlta = null;
        if (fechaInternacion.compareTo(hoy) > 0) throw new PacienteException("ERROR!!! Internación("+ fechaInternacion +") no puede ser POSTERIOR a hoy(" + hoy + ")");
        else this.fechaInternacion = fechaInternacion;
    }

    public Date getFechaInternacion() { return fechaInternacion; }
    public Date getFechaAlta() { return fechaAlta; }

    public void darAlta(Date fechaAlta) throws PacienteException {
        if (fechaAlta.compareTo(fechaInternacion) > 0) {
            this.fechaAlta = fechaAlta;
            System.out.println("Paciente dado de alta el " + fechaAlta);
        }
        else throw new PacienteException("ERROR!!! Alta (" + fechaAlta + ") es ANTERIOR a internación (" + fechaInternacion + ")");
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI='" + DNI + '\'' +
                ", fechaInternacion=" + fechaInternacion +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
