package Gobierno;

public abstract class Procesador {
    private Procesador siguienteProcesador;

    public Procesador getSiguienteProcesador() { return siguienteProcesador; }
    public void setSiguienteProcesador(Procesador siguienteProcesador) {
        this.siguienteProcesador = siguienteProcesador;
    }

    public abstract String procesarDocumento(Documento documento);
}