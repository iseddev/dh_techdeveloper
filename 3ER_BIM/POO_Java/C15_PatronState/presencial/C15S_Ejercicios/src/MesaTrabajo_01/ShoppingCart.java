package MesaTrabajo_01;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends State {

    // El carrito tiene un estado Y un conjunto de productos
    private State currentState;
    private List<Item> itemList;

    public ShoppingCart() {
        this.currentState = new IsEmpty();
        itemList = new ArrayList<>();
    }

    @Override
    public void addProduct(Item item) {
        currentState.addProduct(item);
        if(currentState instanceof IsEmpty) {
            itemList.add(item);
            currentState = new IsLoading(itemList);
        } else if(currentState instanceof IsLoading) {
            itemList.add(item);
            currentState = new IsLoading(itemList);
        } else if(currentState instanceof IsPaying) {
            System.out.println("Procesando pago, no es posible agregar más productos...");
            currentState = new IsCLosed();
        }
    }

    @Override
    public void cancelPurchase() {

    }

    @Override
    public void backPreviousPoint() {

    }

    @Override
    public void goNextState() {

    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public List<Item> getItemList() { return itemList; }
}
