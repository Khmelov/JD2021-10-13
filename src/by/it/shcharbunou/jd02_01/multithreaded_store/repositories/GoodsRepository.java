package by.it.shcharbunou.jd02_01.multithreaded_store.repositories;

import by.it.shcharbunou.jd02_01.multithreaded_store.entities.products.Good;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsRepository {

    private static GoodsRepository instance;
    private final List<Good> goods;

    private GoodsRepository(){
        goods = new ArrayList<>();
        goods.add(new Good("Trojan", new BigDecimal(300)));
        goods.add(new Good("Bot", new BigDecimal(250)));
        goods.add(new Good("Exploit", new BigDecimal(600)));
        goods.add(new Good("Crypt", new BigDecimal(1200)));
        goods.add(new Good("DDOS", new BigDecimal(2000)));
        goods.add(new Good("Access", new BigDecimal(1500)));
    }

    public static GoodsRepository getInstance() {
        if (instance == null) {
            instance = new GoodsRepository();
        }
        return instance;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public static void setInstance(GoodsRepository instance) {
        GoodsRepository.instance = instance;
    }
}
