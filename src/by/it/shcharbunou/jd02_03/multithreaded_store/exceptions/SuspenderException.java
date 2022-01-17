package by.it.shcharbunou.jd02_03.multithreaded_store.exceptions;

public class SuspenderException extends RuntimeException {

    public SuspenderException(String message) {
        super(message);
    }

    public SuspenderException(String message, Throwable cause) {
        super(message, cause);
    }
}
