package Testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
    @Test
    public void casoUno() {
        // Arrange => dado lo que se necesita para hacer la prueba
        Persona juan = new Persona("Juan", 20);
        Persona pedro = new Persona("Pedro", 20);
        Persona ana = new Persona("Ana", 20);
        Persona luz = new Persona("Luz", 20);
        Persona juliam = new Persona("Julian", 20);

        Grupo grupo1 = new Grupo();

        // Act => ocurre el proceso, la acción
        grupo1.agregarPersona(juan);
        grupo1.agregarPersona(pedro);
        grupo1.agregarPersona(ana);
        grupo1.agregarPersona(luz);
        grupo1.agregarPersona(juliam);

        // Assert => Realizamos la prueba para validar los resultados esperados
        assertTrue(grupo1.getPersonas().size() == 2);
    }

    @Test
    public void casoDos() {
        // arrange => dado lo que se necesita para hacer la prueba
        Persona juanito = new Persona("Juanito", 18);
        Persona pedro = new Persona("Pedro", 17);
        Persona anita = new Persona("Anita", 22);
        Persona luciana = new Persona("Luciana", 14);
        Persona juliam = new Persona("Julian", 32);

        Grupo grupo2 = new Grupo();

        // act => ocurre el proceso, la acción
        grupo2.agregarPersona(juanito);
        grupo2.agregarPersona(pedro);
        grupo2.agregarPersona(anita);
        grupo2.agregarPersona(luciana);
        grupo2.agregarPersona(juliam);

        // assert => comparo con  lo que espero
        assertEquals(3, grupo2.getPersonas().size());
    }

    @Test
    public void casoTres() {
        // Arrange => Dado lo que se necesita para hacer la prueba
        Persona nicolas = new Persona("N1c0las", 20);
        Persona tomas = new Persona("Tomas", 20);
        Persona esteban = new Persona("3steban", 20);
        Persona carlos = new Persona("Carlos\\sV", 20);
        Persona francisco = new Persona("Francisco\\sII", 20);

        Grupo grupo3 = new Grupo();

        // Act => Ocurre el proceso, la acción
        grupo3.agregarPersona(nicolas);
        grupo3.agregarPersona(tomas);
        grupo3.agregarPersona(esteban);
        grupo3.agregarPersona(carlos);
        grupo3.agregarPersona(francisco);

        // Assert => Comparo con  lo que espero
        assertEquals(1, grupo3.getPersonas().size());
    }
}