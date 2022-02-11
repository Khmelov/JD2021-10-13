package by.it.antipov.jd02_02.model;


import java.util.HashMap;
import java.util.Map;

public class PriceList {
   static final Map<String,Double> priceList = new HashMap<>();
    static {
        priceList.put("bread", 4.0);
        priceList.put("vodka", 5.0);
        priceList.put("meat", 7.0);
        priceList.put("water", 1.0);
        priceList.put("milk", 3.0);
    }
}
