package Gobierno;

public class Procesamiento {

    private Procesador procesarReservado;

    public String procesarCategoria(Documento documento) {
        return procesarReservado.procesarDocumento(documento);
    }

    public Procesamiento(){
        procesarReservado = new ProcesadorReservado();
        Procesador procesarSecreto = new ProcesadorSecreto();
        Procesador procesarMuySecreto = new ProcesadorMuySecreto();

        procesarReservado.setSiguienteProcesador(procesarSecreto);
        procesarSecreto.setSiguienteProcesador(procesarMuySecreto);
    }
}
