package by.it.rudakova.jd02_01.repository;

import by.it._classwork_.jd02_01.model.Good;
import by.it.rudakova.jd02_01.model.Goods;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PriceListRepo {

    private final Map<Goods, Double> goods=new HashMap();

    public PriceListRepo() {
    }

    public void setPriceForProduct(Goods product, Double price){
        goods.put(product, price);
    }

    public double getProductPrice(Goods product){
        return (Double)goods.get(product);
    }
}
