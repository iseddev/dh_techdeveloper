package Almacen;

// Clase que "extiende" de la Clase Verificador
public class VerificadorPeso extends Controlador {

    @Override
    public String verificarCalidad(Articulo articulo) {
        // Se implementa la lógica el método abstracto (proveniente/heredado de Verificador) que se aplicará para verificar la calidad del articulo recibido como parámetro
        // ● Peso: debe estar entre 1200 y 1300.
        if(articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300) {
            System.out.println("Articulo satisface la verificación de PESO, pasa a la siguiente etapa...");
            // Si se cumple la condición, pasa el artículo al siguiente verificador y se aplica el proceso (método) de verificarCalidad
            return getControladorSiguiente().verificarCalidad(articulo);
        } else {
            // Si no se cumple lo anterior, se termina el proceso y el "estado" del artículo es "RECHAZADO"
            System.out.println("Artículo no paso prueba de calidad por PESO...");
            return "Artículo no pasó verificación de PESO, estado del artículo: RECHAZADO";
        }
    }
}