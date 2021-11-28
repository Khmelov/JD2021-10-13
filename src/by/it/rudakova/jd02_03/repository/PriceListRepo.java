package by.it.rudakova.jd02_03.repository;

import by.it.rudakova.jd02_03.model.Goods;

import java.util.HashMap;
import java.util.Map;

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
