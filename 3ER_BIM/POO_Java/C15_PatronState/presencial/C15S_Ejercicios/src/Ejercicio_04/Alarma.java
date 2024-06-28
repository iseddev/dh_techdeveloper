package Ejercicio_04;


// Clase contexto
public class Alarma {
    private EstadoAlarma estadoActual;

    public Alarma() { estadoActual = new Sonando(); }

    public void actualizarEstado(EstadoAlarma estadoNuevo) { estadoActual = estadoNuevo; }

    public void procesar() { estadoActual.procesar(this); }
}
