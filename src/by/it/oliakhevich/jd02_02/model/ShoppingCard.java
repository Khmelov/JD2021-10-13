package by.it.oliakhevich.jd02_02.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCard {
    private List<Good> cart;
    public ShoppingCard(){
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
