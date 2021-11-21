package by.it.oliakhevich.jd02_01.service;

import by.it.oliakhevich.jd02_01.helperstore.RandomInt;
import by.it.oliakhevich.jd02_01.helperstore.Timeout;
import by.it.oliakhevich.jd02_01.model.Customer;
import by.it.oliakhevich.jd02_01.model.Good;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;

    public CustomerWorker() {
        throw new StoreException("not customer");
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
        System.out.printf("%s entered to the Store%n", customer);
    }

    @Override
    public Good chooseGood() {
        Good good = GoodCreator.random();
        int timeout = RandomInt.random(500, 2000);
        Timeout.sleep(timeout);
        System.out.printf("%s choose %s%n", customer, good);
        return good;
    }

    @Override
    public void goOut() {
        System.out.printf("%s leaves the Store%n", customer);
    }
}

