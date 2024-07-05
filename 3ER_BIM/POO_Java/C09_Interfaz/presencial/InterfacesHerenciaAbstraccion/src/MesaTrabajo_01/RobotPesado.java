package MesaTrabajo_01;

public class RobotPesado extends SistemaArmas implements Operaciones, Volar {
    @Override
    void mostrar() { System.out.println("RobotPesado en ejecución"); }
    @Override
    public void atacar() { System.out.println("RobotPesado atacando"); }
    @Override
    public void defender() { System.out.println("RobotPesado defendiendo"); }
    @Override
    public void volar() { System.out.println("RobotPesado volando"); }
}
