package Gobierno;

public class ProcesadorMuySecreto extends Procesador {
    @Override
    public String procesarDocumento(Documento documento) {
        if(documento.getTipo().equals(1) || documento.getTipo().equals(2) || documento.getTipo().equals(3)) {
            return "Documento de acceso y lectura por Presidente";
        } else { return "Error en tipo de documento, revisar esta información..."; }
    }
}