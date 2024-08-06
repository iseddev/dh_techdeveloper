package CentroVacunacion;

import java.time.LocalDate;

public class Paciente {
    private String nombre, apellido, dni, nombreVacuna;
    LocalDate fechaVacunacion;

    public Paciente(String nombre, String apellido, String dni, String nombreVacuna, LocalDate fechaVacunacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nombreVacuna = nombreVacuna;
        this.fechaVacunacion = fechaVacunacion;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDni() { return dni; }
    public String getNombreVacuna() { return nombreVacuna; }
    public LocalDate getFechaVacunacion() { return fechaVacunacion; }
}
