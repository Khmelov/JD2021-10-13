package by.it.shcharbunou.jd02_01.multithreaded_store.exceptions;

public class StoreException extends RuntimeException {

    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
