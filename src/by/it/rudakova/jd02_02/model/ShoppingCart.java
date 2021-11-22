package by.it.rudakova.jd02_02.model;

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
