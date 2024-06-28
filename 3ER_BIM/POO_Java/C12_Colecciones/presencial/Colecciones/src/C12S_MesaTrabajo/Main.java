package C12S_MesaTrabajo;

public class Main {
    public static void main(String[] args) {

        Puerto mazatlan = new Puerto();

        mazatlan.agregarContenedor(50, Pais.CANADA, true);
        mazatlan.agregarContenedor(5, Pais.CHINA, false);
        mazatlan.agregarContenedor(12, Pais.DESCONOCIDO, true);
        mazatlan.agregarContenedor(6, Pais.BRASIL, false);
        mazatlan.agregarContenedor(34, Pais.DESCONOCIDO, false);
        mazatlan.agregarContenedor(2, Pais.DESCONOCIDO, true);

        mazatlan.mostrarContenedoresOrdenados();
        System.out.println("DESCONOCIDOS y peligrosos: " + mazatlan.contarContenedoresPeligrosos());
    }
}