package ExamenFinal;

public class Test {
    public static void main(String[] args) {
        Simple muzarella = new Simple("muzarella", "Pizza de con muzarella de primera calidad", 700, false);
        Simple margarita = new Simple("margarita", "Especial margarita", 850, true);
        Simple anana = new Simple("ananá", "Pizza anana super crujiente", 950, false);
        Combinada loca = new Combinada("loca", "Combinada Loca");
        loca.agregarPizza(margarita);
        loca.agregarPizza(anana);

        System.out.println(muzarella);
        System.out.println(margarita);
        System.out.println(anana);
        System.out.println(loca);
    }
}
