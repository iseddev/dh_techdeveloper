package MesaTrabajo_01;

public class Main {
    public static void main(String[] args) {

        Item milk = new Item("milk", 25.0);
        Item bread =  new Item("pan", 23.0);
        Item egg = new Item("huevos", 32.2);
        Item flour = new Item("harina", 20.0);
        Item water =  new Item("agua", 15.0);

        ShoppingCart cart = new ShoppingCart();
        System.out.println(cart.getCurrentState());
        cart.addProduct(milk);
        System.out.println(cart.getCurrentState());
        cart.addProduct(bread);
        cart.addProduct(egg);
        cart.addProduct(flour);
        cart.addProduct(water);
        System.out.println(cart.getCurrentState());
    }
}
