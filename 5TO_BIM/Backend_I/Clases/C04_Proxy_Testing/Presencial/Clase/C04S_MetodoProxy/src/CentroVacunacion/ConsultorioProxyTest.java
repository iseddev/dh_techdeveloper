package CentroVacunacion;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConsultorioProxyTest {

    @Test
    public void casoUno() {
        // Arrange
        Paciente paciente = new Paciente("John", "Doe", "123", "Pfizer", LocalDate.of(2024,3,1));
        ConsultorioProxy control = new ConsultorioProxy();
        String expected = "Vacunación confirmada de: 123 con fecha asignada: 2024-03-01 y vacuna Pfizer";;

        // Act
        String obtained = control.vacunar(paciente);

        // Assert
        assertEquals(expected, obtained);
    }

}