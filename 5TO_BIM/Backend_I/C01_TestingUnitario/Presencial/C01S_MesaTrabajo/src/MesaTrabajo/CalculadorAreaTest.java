package MesaTrabajo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadorAreaTest {
    @Test
    public void TestCuadradoOne() {
        // Init
        FiguraGeometrica cuadradoUno = new FiguraGeometricaCuadrado(5d);
        CalculadorArea areaCuadrado = new CalculadorAreaCuadrado();
        String expected = "El area del cuadrado es 25.0 unidades cuadradas";

        // Act
        String current = areaCuadrado.calcularArea(cuadradoUno.getValue());

        // Assert
        assertEquals(expected, current);
    }

    @Test
    public void TestCuadradoTwo() {
        // Init
        FiguraGeometrica cuadradoUno = new FiguraGeometricaCuadrado(0d);
        CalculadorArea areaCuadrado = new CalculadorAreaCuadrado();
        String expected = "El valor del lado debe ser mayor que cero";

        // Act
        String current = areaCuadrado.calcularArea(cuadradoUno.getValue());

        // Assert
        assertEquals(expected, current);
    }

    @Test
    public void TestCirculoUno() {
        // Init
        FiguraGeometrica circuloUno = new FiguraGeometricaCirculo(5d);
        CalculadorArea areaCirculo = new CalculadorAreaCirculo();
        String expected = "El área del círculo es 78.54 unidades cuadradas";

        // Act
        String current = areaCirculo.calcularArea(circuloUno.getValue());

        // Assert
        assertEquals(expected, current);
    }

    @Test
    public void TestCirculoTwo() {
        // Init
        FiguraGeometrica circuloUno = new FiguraGeometricaCirculo(0d);
        CalculadorArea areaCirculo = new CalculadorAreaCirculo();
        String expected = "El valor del radio debe ser mayor que cero";

        // Act
        String current = areaCirculo.calcularArea(circuloUno.getValue());

        // Assert
        assertEquals(expected, current);
    }
}