package MesaTrabajo_01;

public class Item {

    // Cada producto tiene solamente descripción y precio
    private String description;
    private double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Description='" + description + '\'' +
                ", Price=" + price +
                '}';
    }
}
