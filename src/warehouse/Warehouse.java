package warehouse;


import com.google.common.collect.Ordering;
import java.util.*;


/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class Warehouse {

    private Map<String, ProductQuantityPair> warehouse;
    private static final int DEFAULT_MAX_QUANTITY = 50;
    private Ordering<Product> byPriceOrdering = new Ordering<Product>() {
        @Override
        public int compare(Product product1, Product product2) {
            if (product1.getPrice() > product2.getPrice()) {
                return 1;
            }
            if (product1.getPrice() < product2.getPrice()) {
                return -1;
            }
            return 0;
        }
    };

    public Warehouse () {
        this.warehouse = new LinkedHashMap<>();
    }

    public Warehouse (Product ... product) {
        this.warehouse = new LinkedHashMap<>();
        for (Product product1 : product) {
            warehouse.put(product1.getName(), new ProductQuantityPair(product1, DEFAULT_MAX_QUANTITY));
        }
    }

    /**
     * Adds new product to the warehouse
     * @param product Product product to be added
     */
    public void add(Product product) {
        if( !warehouse.containsKey(product.getName()) ) {
           warehouse.put(product.getName(), new ProductQuantityPair(product , DEFAULT_MAX_QUANTITY));
           return;
        }
        int newQuantity = warehouse.get(product.getName()).productQuantity() + product.getQuantity();
        if (newQuantity > warehouse.get(product.getName()).getMaxQuantity()) {
            throw new MaximumQuantityException("Maximum quantity reached. Can't add");
        }
        warehouse.get(product.getName()).productQuantityEdit(newQuantity);
    }


    public Map<String,ProductQuantityPair> inventory() {
        return warehouse;
    }

    /**
     * Sells a product from warehouse
     * @param product Product product to be sold
     * @param quantity int Quantity of the product to be sold
     */
    public void sell(Product product, int quantity) {
        int newQuantity = warehouse.get(product.getName()).productQuantity() - quantity;
        if (newQuantity < 0) {
            throw new OutOfStockException("This product is out of stock");
        }
        warehouse.get(product.getName()).productQuantityEdit(newQuantity);
    }

    /**
     * Sorts warehouse items by price
     * @return List sorted list of warehouse items
     */
    public List<Product> sort() {
        return byPriceOrdering.immutableSortedCopy(productList());
    }


    private List<Product> productList () {
        List<Product> list = new ArrayList<>();
        warehouse.values().stream().forEach(productQuantityPair -> list.add(productQuantityPair.getProduct()));
        return list;
    }

}
