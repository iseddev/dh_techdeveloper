package Herencia;

public class Main {
    public static void main(String[] args) {
        SocioAlberca socioA1 = new SocioAlberca(1001, "Israel", 500.00, "Cardio", 110.00);
        System.out.println(socioA1.calcularCuotaMensual());
        System.out.println(socioA1.calcularCuotaMoratoria());
        SocioAlberca socioA2 = new SocioAlberca(1002, "Eduardo", 500.00, "Spinnig", 110.00);
        socioA2.setEstaHabilitado(true);
        System.out.println(socioA2.calcularCuotaMensual());
        System.out.println(socioA2.calcularCuotaMoratoria());
    }
}
