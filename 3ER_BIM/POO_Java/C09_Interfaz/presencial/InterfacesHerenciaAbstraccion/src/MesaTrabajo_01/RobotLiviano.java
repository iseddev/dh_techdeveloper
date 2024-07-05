package MesaTrabajo_01;

public class RobotLiviano extends SistemaArmas implements Operaciones, Volar{

    @Override
    void mostrar() { System.out.println("RobotLiviano en ejecución"); }
    @Override
    public void atacar() { System.out.println("RobotLiviano atacando"); }
    @Override
    public void defender() { System.out.println("RobotLiviano defendiendo"); }
    @Override
    public void volar() { System.out.println("RobotLiviano volando"); }
}
