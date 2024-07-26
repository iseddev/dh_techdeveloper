package Almacen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalistaDeCalidadTest {

    @Test
    public void casoUno() {
        // Arrange
        Articulo articuloUno = new Articulo("Item1", "sano", 1100, 1210);
        AnalistaDeCalidad analista = new AnalistaDeCalidad();
        String expected = "Estado del artículo: ACEPTADO";

        // Act
        String obtained = analista.analizarCalidad(articuloUno);

        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    public void casoDos() {
        // Arrange
        Articulo articuloDos = new Articulo("Item2", "casi sano", 1900, 1290);
        AnalistaDeCalidad analista = new AnalistaDeCalidad();
        String expected = "Estado del artículo: ACEPTADO";

        // Act
        String obtained = analista.analizarCalidad(articuloDos);

        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    public void casoTres() {
        // Arrange
        Articulo articuloTres = new Articulo("Item3", "casi sano", 2001, 1250);
        AnalistaDeCalidad analista = new AnalistaDeCalidad();
        String expected = "Artículo no pasó verificación de LOTE, estado del artículo: RECHAZADO";

        // Act
        String obtained = analista.analizarCalidad(articuloTres);

        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    public void casoCuatro() {
        // Arrange
        Articulo articuloCuatro = new Articulo("Item4", "medio sano", 1900, 1199);
        AnalistaDeCalidad analista = new AnalistaDeCalidad();
        String expected = "Artículo no pasó verificación de PESO, estado del artículo: RECHAZADO";

        // Act
        String obtained = analista.analizarCalidad(articuloCuatro);

        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    public void casoCinco() {
        // Arrange
        Articulo articuloCinco = new Articulo("Item5", "medio sano", 1900, 1290);
        AnalistaDeCalidad analista = new AnalistaDeCalidad();
        String expected = "Artículo no pasó verificación de ENVASE, estado del artículo: RECHAZADO";

        // Act
        String obtained = analista.analizarCalidad(articuloCinco);

        // Assert
        assertEquals(expected, obtained);
    }
}