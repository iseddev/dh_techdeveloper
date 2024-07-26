package CentroVacunacion;

public class Consultorio implements IConsultorio {
    @Override
    public String vacunar(Paciente paciente) {
        return "Vacunación confirmada de: " + paciente.getDni()
                + " con fecha asignada: " + paciente.getFechaVacunacion()
                + " y vacuna " + paciente.getNombreVacuna();
    }
}