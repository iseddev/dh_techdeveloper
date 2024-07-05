package C16A_Ejemplo_01;

public class Main {
    public static void main(String[] args) {
        Depto ventas = new DeptoVentas(1, "Depto de Ventas");
        Depto financiero = new DeptoFinanciero(2, "Depto Financiero");
        Depto test = new DeptoTest(4, "Prueba");

        DeptoComposite composite = new DeptoComposite(3, "Composite");

        composite.addDepto(ventas);
        composite.addDepto(financiero);
        composite.addDepto(test);
        composite.getName();
    }
}