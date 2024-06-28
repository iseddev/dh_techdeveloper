package Ejercicio_03;

public class Bloqueada implements Estado {
    @Override
    public void controlarEstado(Cuenta cta) { cta.setEstado(new Activa()); }

    @Override
    public void verEstado() { System.out.println("Estado actual de la cuenta: BLOQUEADA"); }
}
