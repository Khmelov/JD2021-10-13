package by.it.ena.jd02_02.repository;

import by.it.ena.jd02_02.model.Good;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {
    private final Map<Good, Double> goods = new HashMap();

    public PriceListRepo() {
    }

    public Map<Good, Double> getGoods() {
        return goods;
    }

}
