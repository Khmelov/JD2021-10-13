package by.it.rudakova.jd02_03.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public List<Goods> listGoods;

    public ShoppingCart(){
        listGoods = new ArrayList<>();
    }

    public int add(Goods product){
        listGoods.add(product);
        return listGoods.size();
    }
}
