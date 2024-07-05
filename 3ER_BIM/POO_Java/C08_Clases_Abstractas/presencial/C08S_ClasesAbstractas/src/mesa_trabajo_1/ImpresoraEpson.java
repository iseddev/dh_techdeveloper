package mesa_trabajo_1;

import java.util.Date;

public class ImpresoraEpson extends Impresora {
    public ImpresoraEpson(String modelo, String tipoConexion, Date fechaFabricacion, int hojasDisponibles, Double porcentajeTinta) {
        super(modelo, tipoConexion, fechaFabricacion, hojasDisponibles, porcentajeTinta);
    }

    @Override
    public String imprimir() {
        return "Imprimiendo desde impresora Epson";
    }
}
