package C13S_MesaTrabajo;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws PacienteException {

        try {
            // Lanzar Exception, ya que la fecha de "internación" (20/08/2025) es mayor a "hoy" (22/03/2050)
            Paciente paciente01 = new Paciente("Jorge", "Perez", "12345", new Date(150, 7, 20));
            System.out.println(paciente01);
        } catch (PacienteException err) { System.err.println(err); }

        try {
            // Se genera exitosamente "internación" (20/08/2021) con fecha anterior a la de "hoy" (22/03/2024)
            Paciente paciente01 = new Paciente("Juan", "Perez", "12345", new Date(121, 7, 20));
            System.out.println(paciente01);
        } catch (PacienteException err) { System.err.println(err); }

        try {
            // Se genera exitosamente "internación" (20/06/2023), pero se genera Exception ya que "alta" (15/08/2022) es anterior a "internación"
            Paciente paciente01 = new Paciente("José", "Perez", "12345", new Date(123, 5, 20));
            System.out.println(paciente01);
            paciente01.darAlta(new Date(122, 7, 15));
        } catch (PacienteException err) { System.err.println(err); }

        try {
            // Se generan exitosamente registro de paciente, "internación" (20/06/2023) y "alta" (15/08/2025)
            Paciente paciente01 = new Paciente("Jerónimo", "Perez", "12345", new Date(123, 5, 20));
            System.out.println(paciente01);
            paciente01.darAlta(new Date(125, 7, 15));
            System.out.println(paciente01);
        } catch (PacienteException err) { System.err.println(err); }

        System.out.println("... continua ejecución del sistema");
    }
}