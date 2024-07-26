package Gobierno;

public class ProcesadorReservado extends Procesador {
    @Override
    public String procesarDocumento(Documento documento) {
        if(documento.getTipo().equals(1)) {
            return "Documento de acceso y lectura por Diputado";
        } else if(documento.getTipo().equals(2)) {
            return getSiguienteProcesador().procesarDocumento(documento);
        } else if (documento.getTipo().equals(3)) {
            return getSiguienteProcesador().procesarDocumento(documento);
        } else { return "Error en tipo de documento, revisar esta información..."; }
    }
}