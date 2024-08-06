package Spotify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDescargaProxyTest {

    @Test
    public void testPremiumValido() {
        // Arrange
        Usuario usuarioPremium = new Usuario("123", TipoUsuario.PREMIUM);
        ServicioDescargaProxy proxyTest = new ServicioDescargaProxy();
        String expected = "Descargando canción para el usuario: 123";

        // Act
        String obtained = proxyTest.descargar(usuarioPremium);

        // Assert
        assertEquals(expected, obtained);
    }

    @Test
    public void testFreeValido() {
        // Arrange
        Usuario usuarioFree = new Usuario("123", TipoUsuario.FREE);
        ServicioDescargaProxy proxyTest = new ServicioDescargaProxy();
        String expected = "Usuario FREE, no es posible descargar canción...";

        // Act
        String obtained = proxyTest.descargar(usuarioFree);

        // Assert
        assertEquals(expected, obtained);
    }
}