package Gobierno;

public class Procesamiento {

    private Procesador procesador;

    public String procesarDocumento(Documento documento) {
        return procesador.procesarDocumento(documento);
    }

    public Procesamiento(){

        // Crear procesadores para cada documento
        procesador = new ProcesadorReservado();
        Procesador procesarSecreto = new ProcesadorSecreto();
        Procesador procesarMuySecreto = new ProcesadorMuySecreto();

        // Armar cadena de procesamiento
        procesador.setSiguienteProcesador(procesarSecreto);
        procesarSecreto.setSiguienteProcesador(procesarMuySecreto);
    }
}
