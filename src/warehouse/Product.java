package warehouse;


import com.google.common.base.Objects;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class Product {

    public final String name;
    public final Double price;



    public Product (String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equal(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, price);
    }
}
