package by.it.shcharbunou.jd02_02.multithreaded_store.services.customer_services;

import by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients.Customer;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.inventory.ShoppingCart;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.products.Good;
import by.it.shcharbunou.jd02_02.multithreaded_store.exceptions.CustomerException;
import by.it.shcharbunou.jd02_02.multithreaded_store.exceptions.ShoppingCartException;
import by.it.shcharbunou.jd02_02.multithreaded_store.services.customer_services.behavior.CustomerAction;
import by.it.shcharbunou.jd02_02.multithreaded_store.services.inventory_services.behavior.ShoppingCartAction;
import by.it.shcharbunou.jd02_02.multithreaded_store.factories.GoodsProducer;
import by.it.shcharbunou.jd02_02.multithreaded_store.factories.PriceListProducer;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Randomizer;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Suspender;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Timer;

import java.util.Objects;

public class CustomerWorker implements Runnable, CustomerAction, ShoppingCartAction {

    private final Customer customer;
    private final GoodsProducer goodsProducer = GoodsProducer.getInstance();
    private final Randomizer randomizer = new Randomizer();
    private final Timer timer = new Timer();
    private final Suspender suspender = new Suspender();
    private ShoppingCart shoppingCart;
    private final PriceListProducer priceListProducer = PriceListProducer.getInstance();

    public CustomerWorker() {
        throw new CustomerException("Error: Unknown customer.");
    }

    public CustomerWorker(Customer customer) {
        this.customer = customer;
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
                System.out.printf("The cart of customer[%d] (%s) has %d goods...\n", customer.getId(),
                        customer.getClass().getSimpleName(), shoppingCartContent);
            }
        } else {
            chooseGood();
        }
        goOut();
    }

    public Good chooseGoodPriceList() {
        suspender.suspend(randomizer.randomize(100, 300));
        Good good = priceListProducer.randomGood();
        System.out.printf("Customer[%d] (%s) has chosen %s...\n", customer.getId(), customer.getClass().getSimpleName(),
                good.getName());
        return good;
    }

    @Override
    public void enteredStore() {
        System.out.printf("Customer[%d] (%s) entered the store...\n", customer.getId(),
                customer.getClass().getSimpleName());
    }

    @Override
    public Good chooseGood() {
        int choosingTime = randomizer.randomize(500, 2000);
        long startTime;
        long currentTime;
        Good good;
        startTime = System.currentTimeMillis();
        do {
            good = goodsProducer.randomGood();
            currentTime = System.currentTimeMillis();
        } while (timer.isRunning(startTime, currentTime, choosingTime));
        System.out.printf("Customer[%d] (%s) has chosen %s...\n", customer.getId(),
                customer.getClass().getSimpleName(), good.getName());
        return good;
    }

    @Override
    public void goOut() {
        System.out.printf("Customer[%d] (%s) has left the shop...\n", customer.getId(),
                customer.getClass().getSimpleName());
    }

    @Override
    public void takeCart() {
        suspender.suspend(randomizer.randomize(100, 300));
        shoppingCart = new ShoppingCart();
        System.out.printf("Customer[%d] (%s) has taken the cart...\n", customer.getId(),
                customer.getClass().getSimpleName());
    }

    @Override
    public int putToCart(Good good) {
        suspender.suspend(randomizer.randomize(100, 300));
        if (Objects.isNull(shoppingCart)) {
            throw new ShoppingCartException("Error: Shopping cart is not taken.");
        }
        shoppingCart.add(good);
        System.out.printf("Customer[%d] (%s) put %s to cart...\n", customer.getId(),
                customer.getClass().getSimpleName(), good.getName());
        return shoppingCart.getContent().size();
    }
}
