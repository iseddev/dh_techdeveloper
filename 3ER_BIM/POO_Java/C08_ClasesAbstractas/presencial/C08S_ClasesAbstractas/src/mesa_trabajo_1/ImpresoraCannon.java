package mesa_trabajo_1;

import java.util.Date;

public class ImpresoraCannon extends Impresora {

    public ImpresoraCannon(String modelo, String tipoConexion, Date fechaFabricacion, int hojasDisponibles, Double porcentajeTinta) {
        super(modelo, tipoConexion, fechaFabricacion, hojasDisponibles, porcentajeTinta);
    }

    @Override
    public String imprimir() { return "Imprimiendo desde impresora Cannon"; }
}
