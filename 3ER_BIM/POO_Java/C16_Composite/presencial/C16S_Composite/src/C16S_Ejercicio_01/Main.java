package C16S_Ejercicio_01;

public class Main {
    public static void main(String[] args) {
        Product burger = new Sandwich("Stellar", 25.0);
        Product potatoes = new Accompaniment("Chip", 2.5);

        System.out.println(burger.getPrice());
        System.out.println(potatoes.getPrice());
    }
}
