package warehouse;

import java.util.Currency;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class Product {

    private final String name;
    private double price;
    private int quantity;


    public Product (String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product (String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setQuantity (int newQuantity) {
        this.quantity = newQuantity;
    }

    public int getQuantity () {
        return quantity;
    }

    public double getPrice () {
        return price;
    }
}
