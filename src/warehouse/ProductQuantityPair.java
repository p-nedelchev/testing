package warehouse;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class ProductQuantityPair {
    private Product product;
    private Integer maxQuantity;

    public ProductQuantityPair(Product product, Integer maxQuantity) {
        this.product = product;
        this.maxQuantity = maxQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Integer maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public int productQuantity () {
        return this.product.getQuantity();
    }

    public void productQuantityEdit (int qunatity) {
        this.product.setQuantity(qunatity);
    }
}
