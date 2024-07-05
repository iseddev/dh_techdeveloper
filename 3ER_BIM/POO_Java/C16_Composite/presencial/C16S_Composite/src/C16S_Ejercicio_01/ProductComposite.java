package C16S_Ejercicio_01;

import java.util.ArrayList;
import java.util.List;

public class ProductComposite extends Product {
    private List<Product> productList;

    public ProductComposite(String name, double price) {
        super(name, price);
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) { productList.add(product); }

    @Override
    public double getPrice() {
        double totalPrice = 0.0;
        for (Product product : productList) { totalPrice += product.getPrice(); }
        return totalPrice * 0.90; // Descuento del 10%
    }
}
