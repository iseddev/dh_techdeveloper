package DocsDrive;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorProxyTest {

  @Test
  public void test01() {
    // Arrange
    Documento doc01 = new Documento("ABC123", "http://docs/db/doc01.txt", "Algo de contenido en el documento 01.", Autorizados.AUTHORIZED);
    ValidadorProxy proxy01 = new ValidadorProxy();
    String expected = "Acceso confirmado al documento: ABC123, en la URL: http://docs/db/doc01.txt, contenido: Algo de contenido en el documento 01.";

    // Act
    String obtained = proxy01.validarAcceso(doc01);

    //Assert
    assertEquals(expected, obtained);
  }

  @Test
  public void test02() {
    // Arrange
    Documento doc02 = new Documento("ABC123", "http://docs/db/doc02.txt", "Algo de contenido en el documento 02.", Autorizados.DENIED);
    ValidadorProxy proxy02 = new ValidadorProxy();
    String expected = "Error en credenciales de acceso...";

    // Act
    String obtained = proxy02.validarAcceso(doc02);

    //Assert
    assertEquals(expected, obtained);
  }
}