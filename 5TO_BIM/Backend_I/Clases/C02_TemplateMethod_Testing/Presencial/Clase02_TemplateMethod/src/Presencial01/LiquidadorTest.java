package Presencial01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorTest {
    /*
    CASO 1: Debería emitir un documento en papel cuando es un empleado efectivo.
    ● Dado: Un empleado efectivo, Martín Martini, con un sueldo básico de 400, un valor fijo de descuentos de 40 y un total de 60 en premios.
    ● Cuando: Intento calcular la liquidación.
    ● Entonces: Obtengo el mensaje “La liquidación generada es un documento impreso. Saldo a liquidar: 420”
     */
    @Test
    public void CasoUno() {
        // Arrange
        Empleado empleado = new EmpleadoEfectivo(
            "Martín",
            "Martini",
            "123",
            400d,
            60d,
            40d);

        Liquidador liquidador = new LiquidadorEfectivo();
        String respuestaEsperada = "La liquidación generada es un documento impreso. Saldo a liquidar: 420.0";

        // Act
        String calcular = liquidador.liquidarSueldo(empleado);

        // Assert
        assertEquals(respuestaEsperada, calcular);
    }

    // ##### Mesa de Trabajo #####
    /*
    CASO 2: Debería emitir un documento digital cuando es un empleado contratado.
        ● Dado: Una empleada contratada, Pompilia Pompini, con 120 horas trabajadas y una tarifa de 7 por hora.
        ● Cuando: Intento calcular la liquidación.
        ● Entonces: Obtengo el mensaje “La liquidación generada es un documento digital. Saldo a liquidar: 840”.
    */
    @Test
    public void CasoDos() {
        // Arrange
        Empleado contratado = new EmpleadoContratado("Pompilia", "Pompini", "456", 7d, 120)
;
        Liquidador liquidador = new LiquidadorContratado();
        String respuestaEsperada = "La liquidación generada es un documento digital. Saldo a liquidar: 840.0";

        // Act
        String respuestaObtenida = liquidador.liquidarSueldo(contratado);

        // Assert
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    /*
    CASO 3: El liquidador debería arrojar un mensaje de error cuando no es posible calcular la liquidación.
        ● Dados: Un liquidador de empleado efectivo y una empleada contratada, Pompilia Pompini.
        ● Cuando: Intento calcular la liquidación.
        ● Entonces: Obtengo el mensaje “La liquidación no pudo ser calculada”.
    */
    @Test
    public void CasoTres() {
        // Arrange
        Liquidador liquidador = new LiquidadorEfectivo();
        Empleado pompini = new EmpleadoContratado("Pompilia", "Pompini", "456", 7d, 120);
        String respuestaEsperada = "La liquidación no pudo ser calculada";

        // Act
        String respuestaObtenida = liquidador.liquidarSueldo(pompini);

        // Assert
        assertEquals(respuestaEsperada, respuestaObtenida);
    }
}