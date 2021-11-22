package by.it.antipov.jd02_02.model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
 public   Map<String,Double> cart;
public ShoppingCart(){
    cart=new HashMap<>();
}
    public void cartAdd(Good good){
        cart.put(good.getName(), PriceList.priceList.get(good.getName()));
    }
    public int cartSize(){
        return cart.size();
    }
}
