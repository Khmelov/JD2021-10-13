package by.it.shcharbunou.jd02_03.multithreaded_store.exceptions;

public class GoodException extends RuntimeException {

    public GoodException(String message) {
        super(message);
    }

    public GoodException(String message, Throwable cause) {
        super(message, cause);
    }
}
