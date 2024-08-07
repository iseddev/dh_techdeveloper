package Computadoras;

public class Main {
    public static void main(String[] args) {

        ComputadoraFactory factory = new ComputadoraFactory();

        Computadora windows1PC = factory.getComputadora(2, 120, "windows1");
        Computadora mac1PC = factory.getComputadora(16, 500, "mac1");
        Computadora windows2PC = factory.getComputadora(2, 120, "windows1");
        Computadora mac2PC = factory.getComputadora(16, 500, "mac1");

        System.out.println(windows1PC);
        System.out.println(mac1PC);
        System.out.println(windows2PC);
        System.out.println(mac2PC);
    }
}
