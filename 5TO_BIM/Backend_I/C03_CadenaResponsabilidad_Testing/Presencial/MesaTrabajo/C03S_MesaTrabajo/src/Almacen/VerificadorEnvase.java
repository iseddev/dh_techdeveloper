package Almacen;

// Clase que "extiende" de la Clase Verificador
public class VerificadorEnvase extends Controlador {

    @Override
    public String verificarCalidad(Articulo articulo) {
        // Se implementa la lógica el método abstracto (proveniente/heredado de Verificador) que se aplicará para verificar la calidad del articulo recibido como parámetro
        // ● Envase: debe ser igual a “sano” o “casi sano”.
        if(articulo.getEnvasado().equals("sano") || articulo.getEnvasado().equals("casi sano")) {
            System.out.println("Articulo satisface la verificación de ENVASE, pasó todas las pruebas...");
            // Si se cumple la condición, el artículo pasó todas las verificaciones y será "aceptado" en el almacén
            return "Estado del artículo: ACEPTADO";
        } else {
            // Si no se cumple lo anterior, se termina el proceso y el "estado" del artículo es "RECHAZADO"
            System.out.println("Artículo no paso prueba de calidad por ENVASE...");
            return "Artículo no pasó verificación de ENVASE, estado del artículo: RECHAZADO";
        }
    }
}
