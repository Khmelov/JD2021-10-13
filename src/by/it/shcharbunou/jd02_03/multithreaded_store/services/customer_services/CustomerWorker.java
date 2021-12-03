package by.it.shcharbunou.jd02_03.multithreaded_store.services.customer_services;

import by.it.shcharbunou.jd02_03.multithreaded_store.entities.clients.Customer;
import by.it.shcharbunou.jd02_03.multithreaded_store.entities.clients.Queue;
import by.it.shcharbunou.jd02_03.multithreaded_store.entities.inventory.ShoppingCart;
import by.it.shcharbunou.jd02_03.multithreaded_store.entities.products.Good;
import by.it.shcharbunou.jd02_03.multithreaded_store.exceptions.CustomerException;
import by.it.shcharbunou.jd02_03.multithreaded_store.exceptions.ShoppingCartException;
import by.it.shcharbunou.jd02_03.multithreaded_store.exceptions.StoreException;
import by.it.shcharbunou.jd02_03.multithreaded_store.factories.GoodsProducer;
import by.it.shcharbunou.jd02_03.multithreaded_store.factories.PriceListProducer;
import by.it.shcharbunou.jd02_03.multithreaded_store.services.customer_services.behavior.CustomerAction;
import by.it.shcharbunou.jd02_03.multithreaded_store.services.inventory_services.behavior.ShoppingCartAction;
import by.it.shcharbunou.jd02_03.multithreaded_store.utils.Manager;
import by.it.shcharbunou.jd02_03.multithreaded_store.utils.Randomizer;
import by.it.shcharbunou.jd02_03.multithreaded_store.utils.Suspender;
import by.it.shcharbunou.jd02_03.multithreaded_store.utils.Timer;

import java.math.BigDecimal;
import java.util.Objects;

public class CustomerWorker implements Runnable, CustomerAction, ShoppingCartAction {

    private final Customer customer;
    private final Manager manager;
    private final Queue queue;
    private final GoodsProducer goodsProducer = GoodsProducer.getInstance();
    private final Randomizer randomizer = new Randomizer();
    private final Timer timer = new Timer();
    private final Suspender suspender = new Suspender();
    private ShoppingCart shoppingCart;
    private final PriceListProducer priceListProducer = PriceListProducer.getInstance();

    public CustomerWorker() {
        throw new CustomerException("Error: Unknown customer.");
    }

    public CustomerWorker(Customer customer, Manager manager, Queue queue) {
        this.customer = customer;
        this.manager = manager;
        this.queue = queue;
        manager.addOneCustomer();
        customer.setProfit(new BigDecimal(0));
    }

    @Override
    public void run() {
        boolean haveGoods = false;
        enteredStore();
        if (randomizer.randomizeBoolean()) {
            haveGoods = true;
            takeCart();
            int goodsCount = randomizer.randomize(2, customer.getMaxGoodsCount());
            for (int i = 0; i < goodsCount; i++) {
                Good good = chooseGoodPriceList();
                int shoppingCartContent = putToCart(good);
                System.out.printf("The cart of customer[%d] (%s) has %d goods...\n", customer.getId(),
                        customer, shoppingCartContent);
            }
        } else {
            if (randomizer.randomize(customer.getMinGoodsCount(), customer.getMaxGoodsCount()) != 0) {
                chooseGood();
                haveGoods = true;
            }
        }
        if (haveGoods) {
            goQueue();
        }

        goOut();
        manager.goOutOneCustomer();
    }

    public Good chooseGoodPriceList() {
        suspender.suspend(randomizer.randomize(100 * customer.getSelectionRateFactor(),
                300 * customer.getSelectionRateFactor()));
        Good good = priceListProducer.randomGood();
        customer.setProfit(customer.getProfit().add(good.getPrice()));
        System.out.printf("Customer[%d] (%s) has chosen %s with price %s...\n", customer.getId(), customer,
                good.getName(), good.getPrice().toString());
        return good;
    }

    @Override
    public void enteredStore() {
        System.out.printf("Customer[%d] (%s) entered the store...\n", customer.getId(), customer);
    }

    @Override
    public Good chooseGood() {
        int choosingTime = randomizer.randomize(500 * customer.getSelectionRateFactor(),
                2000 * customer.getSelectionRateFactor());
        long startTime;
        long currentTime;
        Good good;
        startTime = System.currentTimeMillis();
        do {
            good = goodsProducer.randomGood();
            currentTime = System.currentTimeMillis();
        } while (timer.isRunning(startTime, currentTime, choosingTime));
        customer.setProfit(customer.getProfit().add(good.getPrice()));
        System.out.printf("Customer[%d] (%s) has chosen %s with price %s...\n", customer.getId(), customer,
                good.getName(), good.getPrice().toString());
        return good;
    }

    @Override
    public void goOut() {
        System.out.printf("Customer[%d] (%s) has left the shop...\n", customer.getId(), customer);
    }

    @Override
    public void takeCart() {
        suspender.suspend(randomizer.randomize(100 * customer.getSelectionRateFactor(),
                300 * customer.getSelectionRateFactor()));
        shoppingCart = new ShoppingCart();
        System.out.printf("Customer[%d] (%s) has taken the cart...\n", customer.getId(), customer);
    }

    @Override
    public int putToCart(Good good) {
        suspender.suspend(randomizer.randomize(100 * customer.getSelectionRateFactor(),
                300 * customer.getSelectionRateFactor()));
        if (Objects.isNull(shoppingCart)) {
            throw new ShoppingCartException("Error: Shopping cart is not taken.");
        }
        shoppingCart.add(good);
        System.out.printf("Customer[%d] (%s) put %s to cart...\n", customer.getId(), customer, good.getName());
        return shoppingCart.getContent().size();
    }

    public void goQueue() {
        synchronized (customer.getMonitor()) {
            queue.add(customer);
            System.out.printf("Customer[%d] got in queue...\n", customer.getId());
            customer.setWaiting(true);
            while (customer.isWaiting()) {
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new StoreException("Error: Interrupted.", e);
                }
            }
        }
    }
}
