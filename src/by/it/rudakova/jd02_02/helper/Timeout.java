package by.it.rudakova.jd02_02.helper;

import by.it._classwork_.jd02_01.service.StoreException;
import by.it.rudakova.jd02_02.Constants;

public class Timeout {
    public static void sleep(int timeout){
        try{
            Thread.sleep(timeout/ Constants.K_SPEED);
        } catch (InterruptedException e){
            throw new StoreException("Interrupted",e);
        }
    }
}
