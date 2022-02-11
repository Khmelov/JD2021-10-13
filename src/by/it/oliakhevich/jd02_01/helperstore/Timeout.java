package by.it.oliakhevich.jd02_01.helperstore;

import by.it.oliakhevich.jd02_01.service.Constants;
import by.it.oliakhevich.jd02_01.service.StoreException;

public class Timeout {

    public static void sleep(int timeout) {
        try{
            Thread.sleep(timeout/ Constants.Speed_read);
        }catch (InterruptedException e ){
            throw new StoreException("Interrupted", e);
        }
    }
}
