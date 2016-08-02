import org.junit.Test;
import warehouse.MaximumQuantityException;
import warehouse.OutOfStockException;
import warehouse.Product;
import warehouse.Warehouse;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class WarehouseTest {
    private Warehouse warehouse = new Warehouse ();
    private Product product0 = new Product ("Sugar", 10, 1.65, 50);
    private Product product1 = new Product("Sugar", 41, 1.65, 50);
    private Product product2 = new Product("Sugar", 15, 1.65, 50);
    private Product product3 = new Product("Salt", 12, 0.44, 50);
    private Product product4 = new Product("Sunflower seed oil", 18, 2.44, 50);
    private Product product5 = new Product("Baking powder", 13, 0.24, 50);
    Product [] sorted = new Product[]{product5, product3, product2, product4};


    @Test
    public void testAddNotExist () {
        int currentSize = warehouse.size();
        warehouse.add(product0);
        assertTrue(warehouse.getWarehouse().size() > currentSize);
    }

    @Test
    public void testAddIfExist () {
        warehouse.add(product0);
        int oldQuantity = warehouse.getWarehouse().get(product0.getName()).getQuantity();
        warehouse.add(product2);
        int newQuantity = warehouse.getWarehouse().get(product0.getName()).getQuantity();
        assertTrue(newQuantity > oldQuantity);
    }

    @Test(expected = MaximumQuantityException.class)
    public void testMaxQuantity () {
        warehouse.add(product0);
        warehouse.add(product1);
    }

    @Test
    public void testSell () {
        warehouse.add(product1);
        int oldQuantity = warehouse.getWarehouse().get(product1.getName()).getQuantity();
        warehouse.sell(product0 , 5);
        int newQuantity = warehouse.getWarehouse().get(product0.getName()).getQuantity();
        assertTrue(newQuantity < oldQuantity);
    }

    @Test(expected = OutOfStockException.class)
    public void testOutOfStock () {
        warehouse.add(product0);
        warehouse.sell(product0 , 11);
    }

    @Test
    public void testSort () {
        warehouse.add(product2);
        warehouse.add(product3);
        warehouse.add(product4);
        warehouse.add(product5);
        assertArrayEquals(warehouse.sort().toArray(), sorted);
    }

}
