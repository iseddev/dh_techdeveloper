package Gobierno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcesamientoTest {
    @Test
    public void casoUno() {
        // Arrange
        Documento doc1 = new Documento("Mensaje reservado", 1);
        Procesamiento procesar = new Procesamiento();
        String expected = "Documento de acceso y lectura por Diputado";

        // Act
        String obtained = procesar.procesarCategoria(doc1);

        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    public void casoDos() {
        // Arrange
        Documento doc1 = new Documento("Mensaje secreto", 2);
        Procesamiento procesar = new Procesamiento();
        String expected = "Documento de acceso y lectura por Ministro";

        // Act
        String obtained = procesar.procesarCategoria(doc1);

        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    public void casoTres() {
        // Arrange
        Documento doc1 = new Documento("Mensaje muy secreto", 3);
        Procesamiento procesar = new Procesamiento();
        String expected = "Documento de acceso y lectura por Presidente";

        // Act
        String obtained = procesar.procesarCategoria(doc1);

        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    public void casoCuatro() {
        // Arrange
        Documento doc1 = new Documento("Mensaje sin nivel adecuado", 6);
        Procesamiento procesar = new Procesamiento();
        String expected = "Error en tipo de documento, revisar esta información...";

        // Act
        String obtained = procesar.procesarCategoria(doc1);

        // Assert
        assertEquals(expected, obtained);
    }
}