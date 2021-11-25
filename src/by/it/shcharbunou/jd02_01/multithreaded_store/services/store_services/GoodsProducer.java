package by.it.shcharbunou.jd02_01.multithreaded_store.services.store_services;

import by.it._classwork_.jd02_01.helper.RandomInt;
import by.it.shcharbunou.jd02_01.multithreaded_store.entities.products.Good;
import by.it.shcharbunou.jd02_01.multithreaded_store.repositories.GoodsRepository;

import java.math.BigDecimal;
import java.util.Set;

public class GoodsProducer {

    private final GoodsRepository goodsRepository;
    private final Set<Good> goods;
    private static GoodsProducer instance;

    private GoodsProducer() {
        goodsRepository = GoodsRepository.getInstance();
        goods = goodsRepository.getGoods();
    }

    public static GoodsProducer getInstance() {
        if (instance == null) {
            instance = new GoodsProducer();
        }
        return instance;
    }

    public Good randomGood() {
        int i = RandomInt.random(0, goods.size() - 1);
        return goods.stream()
                .skip(i)
                .findAny()
                .orElse(new Good("", new BigDecimal(0)));
    }

    public static void setInstance(GoodsProducer instance) {
        GoodsProducer.instance = instance;
    }
}
