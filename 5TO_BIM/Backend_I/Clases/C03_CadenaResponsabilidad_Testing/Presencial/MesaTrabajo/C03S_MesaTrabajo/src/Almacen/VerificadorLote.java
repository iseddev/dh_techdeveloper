package Almacen;

// Clase que "extiende" de la Clase Verificador
public class VerificadorLote extends Controlador {

    @Override
    public String verificarCalidad(Articulo articulo) {
        // Se implementa la lógica el método abstracto (proveniente/heredado de Verificador) que se aplicará para verificar la calidad del articulo recibido como parámetro
        // ● Lote: debe estar entre 1000 y 2000.
        if(articulo.getLote() >= 1000 && articulo.getLote() <= 2000) {
            System.out.println("Articulo satisface la verificación de LOTE, pasa a la siguiente etapa...");
            // Si se cumple la condición, pasa el artículo al siguiente verificador y se aplica el proceso (método) de verificarCalidad
            return getControladorSiguiente().verificarCalidad(articulo);
        } else {
            // Si no se cumple lo anterior, se termina el proceso y el "estado" del artículo es "RECHAZADO"
            System.out.println("Artículo no paso prueba de calidad por LOTE...");
            return "Artículo no pasó verificación de LOTE, estado del artículo: RECHAZADO";
        }
    }
}