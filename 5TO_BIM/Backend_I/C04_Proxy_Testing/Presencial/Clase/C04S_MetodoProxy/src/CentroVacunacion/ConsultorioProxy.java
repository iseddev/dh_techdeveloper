package CentroVacunacion;

import java.time.LocalDate;

public class ConsultorioProxy implements IConsultorio{

    private Consultorio consultorio;

    public ConsultorioProxy() { this.consultorio = new Consultorio(); }

    @Override
    public String vacunar(Paciente paciente) {
        LocalDate hoy = LocalDate.now();
        if(hoy.isAfter(paciente.getFechaVacunacion())) {
            // Si es posterioe se tiene que vacunar
            // TODO crear el atributo y la instacia
            return consultorio.vacunar(paciente);
        }
        return "No se puede vacunar. Vuelve luego de la fecha asignada.";
    }
}