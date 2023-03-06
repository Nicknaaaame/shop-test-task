package shop.exception;

public class ElectronicsIsNotInStockException extends Exception {
    public ElectronicsIsNotInStockException(long id) {
        super(String.format("Product with id: %d is not in stock", id));
    }
}
