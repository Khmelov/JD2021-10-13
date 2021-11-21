package by.it.karmyzov.jd02_01.service;

public class StoreExeption extends RuntimeException {
    public StoreExeption(String message) {
        super(message);
    }

    public StoreExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
