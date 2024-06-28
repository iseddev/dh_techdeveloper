package Ejercicio_04;

public class Silenciada implements EstadoAlarma{
    @Override
    public void procesar(Alarma alarma) { System.out.println("Alarma silenciada"); }
}
