package by.it.shcharbunou.jd02_01.multithreaded_store.services.customer_services;

import by.it.shcharbunou.jd02_01.multithreaded_store.entities.clients.Customer;
import by.it.shcharbunou.jd02_01.multithreaded_store.entities.inventory.ShoppingCart;
import by.it.shcharbunou.jd02_01.multithreaded_store.entities.products.Good;
import by.it.shcharbunou.jd02_01.multithreaded_store.exceptions.CustomerException;
import by.it.shcharbunou.jd02_01.multithreaded_store.exceptions.ShoppingCartException;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.customer_services.behavior.CustomerAction;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.inventory_services.behavior.ShoppingCartAction;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.store_services.GoodsProducer;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.store_services.PriceListProducer;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Randomizer;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Suspender;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Timer;

import java.util.Objects;

public class PensionerWorker implements Runnable, CustomerAction, ShoppingCartAction {

    private final Customer pensioner;
    private final GoodsProducer goodsProducer = GoodsProducer.getInstance();
    private final Randomizer randomizer = new Randomizer();
    private final Timer timer = new Timer();
    private final Suspender suspender = new Suspender();
    private ShoppingCart shoppingCart;
    private final PriceListProducer priceListProducer = PriceListProducer.getInstance();
    private static final int delay = 3 / 2 + 1;

    public PensionerWorker() {
        throw new CustomerException("Error: Unknown customer.");
    }

    public PensionerWorker(Customer pensioner) {
        this.pensioner = pensioner;
    }

    @Override
    public void run() {
        enteredStore();
        if (randomizer.randomizeBoolean()) {
            takeCart();
            int goodsCount = randomizer.randomize(2, 5);
            for (int i = 0; i < goodsCount; i++) {
                Good good = chooseGoodPriceList();
                int shoppingCartContent = putToCart(good);
                System.out.printf("The cart of customer[%d] (Pensioner) has %d goods...\n", pensioner.getId(), shoppingCartContent);
            }
        } else {
            chooseGood();
        }
        goOut();
    }

    public Good chooseGoodPriceList() {
        suspender.suspend(randomizer.randomize(100, 300) * delay);
        Good good = priceListProducer.randomGood();
        System.out.printf("Customer[%d] (Pensioner) has chosen %s...\n", pensioner.getId(), good.getName());
        return good;
    }

    @Override
    public void enteredStore() {
        System.out.printf("Customer[%d] (Pensioner) entered the store...\n", pensioner.getId());
    }

    @Override
    public Good chooseGood() {
        int choosingTime = randomizer.randomize(500, 2000) * delay;
        long startTime;
        long currentTime;
        Good good;
        startTime = System.currentTimeMillis();
        do {
            good = goodsProducer.randomGood();
            currentTime = System.currentTimeMillis();
        } while (timer.isRunning(startTime, currentTime, choosingTime));
        System.out.printf("Customer[%d] (Pensioner) has chosen %s...\n", pensioner.getId(), good.getName());
        return good;
    }

    @Override
    public void goOut() {
        System.out.printf("Customer[%d] (Pensioner) has left the shop...\n", pensioner.getId());
    }

    @Override
    public void takeCart() {
        suspender.suspend(randomizer.randomize(100, 300) * delay);
        shoppingCart = new ShoppingCart();
        System.out.printf("Customer[%d] (Pensioner) has taken the cart...\n", pensioner.getId());
    }

    @Override
    public int putToCart(Good good) {
        suspender.suspend(randomizer.randomize(100, 300) * delay);
        if (Objects.isNull(shoppingCart)) {
            throw new ShoppingCartException("Error: Shopping cart is not taken.");
        }
        shoppingCart.add(good);
        System.out.printf("Customer[%d] (Pensioner) put %s to cart...\n", pensioner.getId(), good.getName());
        return shoppingCart.getContent().size();
    }
}
