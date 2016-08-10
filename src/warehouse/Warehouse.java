package warehouse;


import com.google.common.collect.Ordering;
import java.util.*;


/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class Warehouse {

    private Map<Product, QuantitiesPair> warehouse;
    private static final Integer DEFAULT_QUANTITY = 0;
    private static final Integer DEFAULT_MAX_QUANTITY = 50;
    private Ordering<Product> byPriceOrdering = new Ordering<Product>() {
        @Override
        public int compare(Product product1, Product product2) {
            if (product1.price > product2.price) {
                return 1;
            }
            if (product1.price < product2.price) {
                return -1;
            }
            return 0;
        }
    };

    public Warehouse () {
        this.warehouse = new LinkedHashMap<>();
    }

    public Warehouse (Product ... products) {
        this.warehouse = new LinkedHashMap<>();
        for (Product product : products) {
            warehouse.put(product, new QuantitiesPair(DEFAULT_QUANTITY, DEFAULT_MAX_QUANTITY));
        }
    }

    public void  add (Product product, Integer quantity ) {
        if ( !warehouse.containsKey(product)) {
            warehouse.put(product, new QuantitiesPair(quantity, DEFAULT_MAX_QUANTITY));
            return;
        }
        Integer newQuantity = warehouse.get(product).quantity + quantity;
        if (warehouse.get(product).maxQuantity < newQuantity) {
            throw new MaximumQuantityException("Maximum quantity exceeded");
        }
        warehouse.get(product).quantity = newQuantity;
    }

    public Map<Product, QuantitiesPair> inventory () {
        return this.warehouse;
    }

    public void sell (Product product, Integer quantity) {
        Integer newQuantity = warehouse.get(product).quantity - quantity;
        if(newQuantity < 0) {
            throw new OutOfStockException("This product is out of stock");
        }
        warehouse.get(product).quantity = newQuantity;
    }

    public List<Product> sortByPrice () {
        List<Product> sorted = new ArrayList<>(warehouse.keySet());
        return byPriceOrdering.immutableSortedCopy(sorted);
    }

}
