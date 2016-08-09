import org.junit.Test;
import warehouse.MaximumQuantityException;
import warehouse.OutOfStockException;
import warehouse.Product;
import warehouse.Warehouse;

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
        warehouse.add(new Product("Apple", 10, 1.23));
        assertThat(warehouse.inventory().size(), is(equalTo(1)));
    }

    @Test
    public void addExistingProduct () {
        Warehouse warehouse = new Warehouse(new Product("Apple", 10, 1.23));
        warehouse.add(new Product("Apple", 23));
        assertThat(warehouse.inventory().get("Apple").getProduct().getQuantity(), is(equalTo(33)));
    }

    @Test(expected = MaximumQuantityException.class)
    public void exceedingMaxQuantity () {
        Warehouse warehouse = new Warehouse();
        Product apple = new Product("Apple", 20, 1.23);
        warehouse.add(apple);
        Product apple2 = new Product("Apple", 32);
        warehouse.add(apple2);
    }

    @Test
    public void sellProduct () {
        Warehouse warehouse = new Warehouse();
        Product apple = new Product("Apple", 20, 1.23);
        warehouse.add(apple);
        warehouse.sell(apple, 8);
        assertThat(warehouse.inventory().get(apple.getName()).getProduct().getQuantity(), is(equalTo(12)));
    }

    @Test(expected = OutOfStockException.class)
    public void sellUnavailableProduct () {
        Warehouse warehouse = new Warehouse();
        Product apple = new Product("Apple", 20, 1.23);
        warehouse.add(apple);
        warehouse.sell(apple, 21);
    }

    @Test
    public void sortProductsByPrice () {
        Product apple = new Product("Apple", 20, 1.23);
        Product pear  = new Product("Pear", 10, 1.98);
        Product watermelon = new Product("Watermelon", 6, 0.48);
        Product orange = new Product("Orange", 15, 2.35);
        Warehouse warehouse = new Warehouse(apple, pear, watermelon, orange);
        assertThat(warehouse.sort().toArray(), is(equalTo(new Product []{watermelon, apple, pear, orange})));
    }

}
