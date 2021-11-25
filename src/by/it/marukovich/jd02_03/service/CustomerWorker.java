package by.it.marukovich.jd02_03.service;

import by.it.marukovich.jd02_03.helper.RandomInt;
import by.it.marukovich.jd02_03.helper.Timeout;
import by.it.marukovich.jd02_03.model.*;

import java.util.concurrent.Semaphore;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;
    private final Manager manager;
    private final Queue queue;
    private final Semaphore semaphore;


    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        manager = store.getManager();
        queue = store.getQueue();
        semaphore = store.getSemaphore();
        manager.addOneCustomer();
    }

    @Override
    public void run() {
        enteredStore();
        Good good = chooseGood();
        customer.setTotal(good.getPrice());
        goQueue();
        goOut();
        manager.goOutOneCustomer();
    }

    @Override
    public void enteredStore() {
        System.out.printf("%s entered to the Store%n", customer);
    }

    @Override
    public Good chooseGood() {
        Good good = null;
        try {
            semaphore.acquire();
            good = GoodCreator.random();
            int timeout = RandomInt.random(500, 2000);
            Timeout.sleep(timeout);
            System.out.printf("%s choose %s%n", customer, good);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return good;
    }

    @Override
    public void goQueue() {
        synchronized (customer.getMonitor()) {
            System.out.printf("%s go to the Queue%n", customer);
            queue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting())
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.printf("%s leaves the Queue%n", customer);
        }
    }

    @Override
    public void goOut() {
        System.out.printf("%s leaves the Store%n", customer);
    }
}
