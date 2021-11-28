package by.it.rudakova.jd02_02.service;

import by.it.rudakova.jd02_02.helper.RandomInt;
import by.it.rudakova.jd02_02.model.Goods;
import by.it.rudakova.jd02_02.repository.GoodListRepo;
import by.it.rudakova.jd02_02.repository.PriceListRepo;

import java.util.Arrays;

public class GoodsProducer {

    private Double margin = 1.1;

    private PriceListRepo priceRepo = new PriceListRepo();
    private GoodListRepo productsRepo = new GoodListRepo();

    private GoodsProducer(){
        Goods[] products = productsRepo.getAllGoods();

        for(Goods product:products){
            priceRepo.setPriceForProduct(product, product.getPrice()*margin);
        }
    }

    public Goods random() {
        Goods[] goods = productsRepo.getAllGoods();
        int i = RandomInt.random(0, goods.length - 1);
        return Arrays.stream(goods)
                .skip(i)
                .findAny()
                .orElse(new Goods());
    }

    private static GoodsProducer instance;

    //singleton
    public static GoodsProducer getInstance(){
        if (instance == null) {
            instance = new GoodsProducer();
        }

        return instance;
    }
}
