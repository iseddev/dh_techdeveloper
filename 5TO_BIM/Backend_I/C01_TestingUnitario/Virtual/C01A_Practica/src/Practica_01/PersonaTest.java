package Practica_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    public void TestNombreCompleto() {

        // Init
        Persona juan = new Persona("Juan", "González", "juang@mail.com", 15);
        String expected = "González, Juan";

        // Act
        String obtained = juan.mostrarNombreCompleto();

        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    public void TestMayorEdad() {
        // Init
        Persona pedro = new Persona("Pedro", "Infante", "pedroi@mail.com", 48);
        String expected = "Pedro SI es mayor de edad";

        // Act
        String obtained = pedro.esMayorDeEdad();

        // Assert
        assertEquals(expected, obtained);
    }
}