package by.it.shcharbunou.jd02_03.multithreaded_store.repositories;

import by.it.shcharbunou.jd02_03.multithreaded_store.entities.products.Good;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {

    private final Map<Good, BigDecimal> priceList = new HashMap<>();
    private static PriceListRepo instance;
    private static final GoodsRepository goodsRepository = GoodsRepository.getInstance();

    private PriceListRepo() {
        for (int i = 0; i < goodsRepository.getGoods().size(); i++) {
            priceList.put(goodsRepository.getGoods().get(i), goodsRepository.getGoods().get(i).getPrice());
        }
    }

    public static PriceListRepo getInstance() {
        if (instance == null) {
            instance = new PriceListRepo();
        }
        return instance;
    }

    public Map<Good, BigDecimal> getPriceList() {
        return priceList;
    }

    public static void setInstance(PriceListRepo instance) {
        PriceListRepo.instance = instance;
    }
}
