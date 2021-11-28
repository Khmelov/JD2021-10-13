package by.it.rudakova.jd02_03.helper;

import by.it.rudakova.jd02_03.service.StoreException;
import by.it.rudakova.jd02_03.Constants;

public class Timeout {
    public static void sleep(int timeout){
        try{
            Thread.sleep(timeout/ Constants.K_SPEED);
        } catch (InterruptedException e){
            throw new StoreException("Interrupted",e);
        }
    }
}
