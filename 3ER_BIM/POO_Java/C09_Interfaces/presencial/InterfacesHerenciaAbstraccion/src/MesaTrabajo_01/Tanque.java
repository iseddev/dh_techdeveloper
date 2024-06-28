package MesaTrabajo_01;

public class Tanque extends SistemaArmas implements Operaciones{

    @Override
    void mostrar() {
        System.out.println("Tanque en ejecución");
    }
    @Override
    public void atacar() { System.out.println("Tanque atacando"); }
    @Override
    public void defender() {
        System.out.println("Tanque defendiendo");
    }
}
