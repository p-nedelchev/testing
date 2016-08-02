package warehouse;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class OutOfStockException extends RuntimeException {

    public OutOfStockException (String message) {
        super(message);
    }
}
