package by.it.karmyzov.jd02_01.helper;

import by.it._classwork_.jd02_01.service.StoreException;
import by.it.karmyzov.jd02_01.Constans;

public class Timeout {
    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Constans.K_SPEED);
        } catch (InterruptedException e) {
            throw  new StoreException("Interrupted", e);
        }
    }
}
