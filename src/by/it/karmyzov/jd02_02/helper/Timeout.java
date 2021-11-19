package by.it.karmyzov.jd02_02.helper;


import by.it.karmyzov.jd02_02.Constans;
import by.it.karmyzov.jd02_02.service.StoreExeption;

public class Timeout {
    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Constans.K_SPEED);
        } catch (InterruptedException e) {
            throw  new StoreExeption("Interrupted", e);
        }
    }
}
