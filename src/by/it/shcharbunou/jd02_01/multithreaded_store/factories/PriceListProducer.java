package by.it.shcharbunou.jd02_01.multithreaded_store.factories;

import by.it.shcharbunou.jd02_01.multithreaded_store.entities.products.Good;
import by.it.shcharbunou.jd02_01.multithreaded_store.repositories.PriceListRepo;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Randomizer;

import java.util.Set;

public class PriceListProducer {

    private final PriceListRepo priceListRepo;
    private static PriceListProducer instance;
    private final Randomizer randomizer = new Randomizer();

    private PriceListProducer() {
        priceListRepo = PriceListRepo.getInstance();
    }

    public static PriceListProducer getInstance() {
        if (instance == null) {
            instance = new PriceListProducer();
        }
        return instance;
    }

    public Good randomGood() {
        Set<Good> goodsSet = priceListRepo.getPriceList().keySet();
        return goodsSet.stream()
                .skip(randomizer.randomize(0, goodsSet.size() - 1))
                .findFirst()
                .get();
    }

    public static void setInstance(PriceListProducer instance) {
        PriceListProducer.instance = instance;
    }
}
