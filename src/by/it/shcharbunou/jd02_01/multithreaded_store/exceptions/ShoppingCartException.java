package by.it.shcharbunou.jd02_01.multithreaded_store.exceptions;

public class ShoppingCartException extends RuntimeException {

    public ShoppingCartException(String message) {
        super(message);
    }

    public ShoppingCartException(String message, Throwable cause) {
        super(message, cause);
    }
}
