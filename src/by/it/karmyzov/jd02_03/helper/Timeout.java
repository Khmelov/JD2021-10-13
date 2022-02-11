package by.it.karmyzov.jd02_03.helper;


import by.it.karmyzov.jd02_03.Constans;
import by.it.karmyzov.jd02_03.service.StoreExeption;

public class Timeout {
    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Constans.K_SPEED);
        } catch (InterruptedException e) {
            throw  new StoreExeption("Interrupted", e);
        }
    }
}
