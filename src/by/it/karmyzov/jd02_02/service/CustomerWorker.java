package by.it.karmyzov.jd02_02.service;

import by.it.karmyzov.jd02_02.helper.RandomInt;
import by.it.karmyzov.jd02_02.helper.Timeout;
import by.it.karmyzov.jd02_02.model.Customer;
import by.it.karmyzov.jd02_02.model.Good;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;

    public CustomerWorker () {
        throw new StoreExeption("not customer");
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
        Good good = GoodCreator.randoom();
        int timeout = RandomInt.random(500,2000);
        Timeout.sleep(timeout);
        System.out.printf("%s choose %s%n", customer,good);
        return null;
    }

    @Override
    public void goOut() {
        System.out.printf("%s leave the Store%n", customer);

    }
}
