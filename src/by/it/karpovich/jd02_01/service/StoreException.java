package by.it.karpovich.jd02_01.service;

import java.io.Serial;

public class StoreException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -9018512421285695511L;

    public StoreException(String message) {
        super(message);
    }

    public StoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
