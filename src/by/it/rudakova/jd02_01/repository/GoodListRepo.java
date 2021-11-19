package by.it.rudakova.jd02_01.repository;

import by.it.rudakova.jd02_01.model.Goods;

import java.util.ArrayList;
import java.util.List;

public class GoodListRepo {

    private List<Goods> products;

    public GoodListRepo(){
        products = new ArrayList<>();
        products.add(new Goods("Bread", 1));
        products.add(new Goods("butter", 2));
        products.add(new Goods("fish", 20));
        products.add(new Goods("Coca-Cola", 22));
        products.add(new Goods("apple", 5));
        products.add(new Goods("orange", 4));
    }

    public Goods[] getAllGoods() {
        return products.toArray(new Goods[products.size()]);
    }

}
