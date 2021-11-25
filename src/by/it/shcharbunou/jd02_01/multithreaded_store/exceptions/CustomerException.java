package by.it.shcharbunou.jd02_01.multithreaded_store.exceptions;

public class CustomerException extends RuntimeException {

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }
}
