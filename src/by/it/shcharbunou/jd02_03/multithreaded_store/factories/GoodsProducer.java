package by.it.shcharbunou.jd02_03.multithreaded_store.factories;

import by.it.shcharbunou.jd02_03.multithreaded_store.entities.products.Good;
import by.it.shcharbunou.jd02_03.multithreaded_store.repositories.GoodsRepository;
import by.it.shcharbunou.jd02_03.multithreaded_store.utils.Randomizer;

public class GoodsProducer {

    private final GoodsRepository goodsRepository;
    private static GoodsProducer instance;
    private final Randomizer randomizer;

    private GoodsProducer() {
        goodsRepository = GoodsRepository.getInstance();
        randomizer = new Randomizer();
    }

    public static GoodsProducer getInstance() {
        if (instance == null) {
            instance = new GoodsProducer();
        }
        return instance;
    }

    public Good randomGood() {
        int i = randomizer.randomize(0, goodsRepository.getGoods().size() - 1);
        return goodsRepository.getGoods().get(i);
    }

    public static void setInstance(GoodsProducer instance) {
        GoodsProducer.instance = instance;
    }
}
