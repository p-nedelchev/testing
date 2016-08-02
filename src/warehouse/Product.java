package warehouse;

import java.util.Currency;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class Product {

    private final String name;
    private double price;
    private int quantity;
    private int maxQuantity;

    public Product(String name, int quantity,double price, int max) {
        this.name = name;
        this.quantity = quantity;
        this.maxQuantity = max;
        this.price = price;
    }

    public Product(String name, Currency price, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public double getPrice() {
        return price;
    }
}
