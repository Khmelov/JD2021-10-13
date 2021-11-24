package by.it.malyshchik.jd02_03.helper;

import by.it.malyshchik.jd02_03.Constants;
import by.it.malyshchik.jd02_03.service.StoreException;

public class Timeout {

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Constants.K_SPEED);
        } catch (InterruptedException e) {
            throw new StoreException("Interrupted", e);
        }
    }
}
