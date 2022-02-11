package by.it.karmyzov.jd02_02.service;

public class StoreExeption extends RuntimeException {
    public StoreExeption(String message) {
        super(message);
    }

    public StoreExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
