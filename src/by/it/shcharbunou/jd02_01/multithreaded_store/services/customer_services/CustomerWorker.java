package by.it.shcharbunou.jd02_01.multithreaded_store.services.customer_services;

import by.it.shcharbunou.jd02_01.multithreaded_store.entities.clients.Customer;
import by.it.shcharbunou.jd02_01.multithreaded_store.entities.products.Good;
import by.it.shcharbunou.jd02_01.multithreaded_store.exceptions.CustomerException;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.customer_services.behavior.CustomerAction;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.store_services.GoodsProducer;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Randomizer;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Timer;

public class CustomerWorker implements Runnable, CustomerAction {

    private final Customer customer;
    private final GoodsProducer goodsProducer = GoodsProducer.getInstance();
    private final Randomizer randomizer = new Randomizer();
    private final Timer timer = new Timer();

    public CustomerWorker() {
        throw new CustomerException("Error: Unknown customer.");
    }

    public CustomerWorker(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.printf("Customer[%d] entered the store...\n", customer.getId());
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
        System.out.printf("Customer[%d] has chosen %s...\n", customer.getId(), good.getName());
        return good;
    }

    @Override
    public void goOut() {
        System.out.printf("Customer[%d] has left the shop...\n", customer.getId());
    }
}
