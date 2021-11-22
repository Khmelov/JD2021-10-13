package by.it.karmyzov.jd02_03.service;


import by.it.karmyzov.jd02_03.helper.RandomInt;
import by.it.karmyzov.jd02_03.helper.Timeout;
import by.it.karmyzov.jd02_03.model.Customer;
import by.it.karmyzov.jd02_03.model.Good;
import by.it.karmyzov.jd02_03.model.Manager;
import by.it.karmyzov.jd02_03.model.Queue;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;
    private final Manager manager;
    private final Queue queue;

    public CustomerWorker(Customer customer, Manager manager, Queue queue) {
        this.customer = customer;
        this.manager = manager;
        this.queue = queue;
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
        Good good = GoodCreator.randoom();
        int timeout = RandomInt.random(500, 2000);
        Timeout.sleep(timeout);
        System.out.printf("%s choose %s%n", customer, good);
        return good;
    }

    @Override
    public void goQueue() {
    synchronized (customer.getMonitor()) {
        System.out.printf("%s go to the Queue", customer);
        queue.add(customer);
        customer.setWaiting(true);
        while (customer.isWaiting())
            try {
                customer.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.printf("%s leaves to the Queue%n", customer);
    }
    }

    @Override
    public void goOut() {
        System.out.printf("%s leave the Store%n", customer);

    }
}
