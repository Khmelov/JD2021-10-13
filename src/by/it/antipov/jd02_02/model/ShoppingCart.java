package by.it.antipov.jd02_02.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
 private List<Good> cart;
public ShoppingCart(){
    cart=new ArrayList<>();
}
    public void cartAdd(Good good){
        cart.add(good);
    }

    public List<Good> getCart() {
        return cart;
    }

    public int cartSize(){
        return cart.size();
    }
}
