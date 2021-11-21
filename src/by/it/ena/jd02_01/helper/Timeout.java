package by.it.ena.jd02_01.helper;

import by.it.ena.jd02_01.service.Constants;
import by.it.ena.jd02_01.service.StoreException;

public class Timeout {public static void sleep(int timeout) {
    try {
        Thread.sleep(timeout / Constants.K_SPEED);
    } catch (InterruptedException e) {
        throw new StoreException("Interrupted", e);
    }
}
}
