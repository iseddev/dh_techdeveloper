package Ejercicio_03;

public class Activa implements Estado {
    @Override
    public void controlarEstado(Cuenta cta) { cta.setEstado(new Bloqueada()); }

    @Override
    public void verEstado() { System.out.println("Estado actual de la cuenta: ACTIVA"); }
}
