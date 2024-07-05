package MesaTrabajo_01;

import java.util.ArrayList;
import java.util.List;

public class IsLoading extends State {

    List<Item> addedItems = new ArrayList<>();

    public IsLoading(List<Item> addedItems) { this.addedItems = addedItems; }

    public void showItemList() { for (Item addedItem : addedItems) { System.out.println("Item: " + addedItem); } }

    @Override
    public void addProduct(Item item) {
        addedItems.add(item);
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

    @Override
    public String toString() {
        return "IsLoading{" +
                "addedItems=" + addedItems +
                '}';
    }
}
