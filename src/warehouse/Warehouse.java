package warehouse;

import warehouse.Product;

import java.util.*;


/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class Warehouse {

    private Map<String, Product> warehouse;
    private Comparator<Product> comparator = new Comparator<Product>() {
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
        warehouse = new LinkedHashMap<>();
    }

    /**
     * Adds new protduct to the warehouse
     * @param product Product product to be added
     */
    public void add(Product product) {
        if (warehouse.containsKey(product.getName())) {
            int newQuantity = warehouse.get(product.getName()).getQuantity() + product.getQuantity();
            if (newQuantity > product.getMaxQuantity()) {
                throw new MaximumQuantityException("Max quantity reached can't add");
            }
            warehouse.get(product.getName()).setQuantity(newQuantity);
            return;
        }
        warehouse.put(product.getName(), product);
    }

    /**
     * Gets current size of warehouse container
     * @return int the size of warehouse
     */
    public int size() {
        return warehouse.size();
    }

    public Map<String,Product> getWarehouse() {
        return warehouse;
    }

    /**
     * Sells a product from warehouse
     * @param product Product product to be sold
     * @param quantity int Quantity of the product to be sold
     */
    public void sell(Product product, int quantity) {
        int newQuantity = warehouse.get(product.getName()).getQuantity() - quantity;
        if ( newQuantity < 0) {
            throw new OutOfStockException("There is not enough amount");
        }
        warehouse.get(product.getName()).setQuantity(newQuantity);
    }

    /**
     * Sorts warehouse items by price
     * @return List sorted list of warehouse items
     */
    public List<Product> sort() {
        List<Product> sorted = new ArrayList<>(warehouse.values());
        Collections.sort(sorted, comparator);
        return sorted;
    }
}
