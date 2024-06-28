package MesaTrabajo_01;

public class Main {
    public static void main(String[] args) {
        RobotLiviano robotL = new RobotLiviano();
        RobotPesado robotP = new RobotPesado();
        Tanque tanque = new Tanque();
        Senuelo senuelo = new Senuelo();

        robotL.mostrar();
        robotL.energia = 100;
        System.out.println("Energía robotL = " + robotL.energia);
        robotL.atacar();
        robotL.defender();
        robotL.volar();
        System.out.println("##############################");
        robotP.energia = 80;
        System.out.println("Energía robotP = " + robotP.energia);
        robotP.mostrar();
        robotP.atacar();
        robotP.defender();
        robotP.volar();
        System.out.println("##############################");
        tanque.energia = 60;
        System.out.println("Energía tanque = " + tanque.energia);
        tanque.mostrar();
        tanque.atacar();
        tanque.defender();
        System.out.println("##############################");
        senuelo.energia = 90;
        System.out.println("Energía señuelo = " + senuelo.energia);
        senuelo.mostrar();
    }
}
