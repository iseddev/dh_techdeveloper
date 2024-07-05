package Ejercicio_04;

public class Main {
    public static void main(String[] args) {
        Alarma alarma = new Alarma();
        alarma.procesar();
        alarma.procesar();
        alarma.actualizarEstado(new Silenciada());
        alarma.procesar();
        alarma.procesar();
        alarma.actualizarEstado(new Sonando());
        alarma.procesar();
    }
}
