package by.it.antipov.jd02_01.model;

import by.it.antipov.jd02_01.Store;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    Map<String,Double> cart;
public ShoppingCart(){
    cart=new HashMap<>();
}
    public void cartAdd(Good good){
        cart.put(good.getName(),PriceList.priceList.get(good.getName()));
    }
    public int cartSize(){
        return cart.size();
    }
}
