import org.junit.Test;
import warehouse.MaximumQuantityException;
import warehouse.OutOfStockException;
import warehouse.Product;
import warehouse.Warehouse;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class WarehouseTest {
    @Test
    public void addNotExistingProduct () {
        Warehouse warehouse = new Warehouse();
        Product product = new Product("Apple", 1.23);
        warehouse.add(product, 25);
        assertThat(warehouse.inventory().size(), is(equalTo(1)));
    }

    @Test
    public void addExistingProduct () {
        Product product = new Product("Pear", 1.78);
        Warehouse warehouse = new Warehouse(product);
        warehouse.add(product, 15);
        assertThat(warehouse.inventory().get(product).quantity, is(equalTo(15)));
    }

    @Test(expected = MaximumQuantityException.class)
    public void exceedMaxQuantity () {
        Warehouse warehouse = new Warehouse();
        Product pear = new Product("Pear", 1.78);
        warehouse.add(pear, 15);
        warehouse.add(pear, 40);
    }

    @Test
    public void sell () {
        Warehouse warehouse = new Warehouse();
        Product orange = new Product("Orange", 2.50);
        warehouse.add(orange, 25);
        warehouse.sell(orange, 10);
        assertThat(warehouse.inventory().get(orange).quantity, is(equalTo(15)));
    }

    @Test(expected = OutOfStockException.class)
    public void sellUnavailableProduct () {
        Product grape = new Product("Grape", 0.89);
        Warehouse warehouse = new Warehouse(grape);
        warehouse.sell(grape, 10);
    }

    @Test
    public void sortedByPrice () {
        Product plum = new Product("Plum", 2.35);
        Product banana = new Product("Banana", 2.20);
        Product lemon = new Product("Lemon", 5.80);
        Product watermelon = new Product("Watermelon", 0.43);
        Product apple = new Product("Apple", 1.23);
        Warehouse warehouse = new Warehouse(plum, banana, lemon, watermelon, apple);
        List<Product> sorted = warehouse.sortByPrice();
        Product [] expected = new Product[]{watermelon, apple, banana, plum, lemon};
        assertThat(sorted.toArray(), is(equalTo(expected)));
    }
}
