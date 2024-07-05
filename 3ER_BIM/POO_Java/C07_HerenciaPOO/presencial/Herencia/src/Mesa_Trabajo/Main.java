package Mesa_Trabajo;

public class Main {
    public static void main(String[] args) {
        Nave spaceX = new Nave(25, 50, 'N', 250, 5);
        System.out.println("SpaceX = " + spaceX);
        spaceX.irA(10, 25, 'S');
        System.out.println("SpaceX = " + spaceX);

        NaveEnemiga apoloX = new NaveEnemiga(50, 10, 'O', 100.0, 5);
        System.out.println("ApoloX = " + apoloX);
        apoloX.irA(10, 25, 'O');
        System.out.println("ApoloX = " + apoloX);

        Asteroide asteroide = new Asteroide(40, 25, 'E', 5);
        System.out.println("Asteroide = " + asteroide);
        asteroide.irA(10, 5, 'N');
        System.out.println("Asteroide = " + asteroide);
    }
}