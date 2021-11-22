package by.it.marukovich.jd02_01.service;

import by.it.marukovich.jd02_01.helper.RandomInt;
import by.it.marukovich.jd02_01.helper.Timeout;
import by.it.marukovich.jd02_01.model.Customer;
import by.it.marukovich.jd02_01.model.Good;

public class CustomerWorker extends Thread implements CustomerAction,ShoppingCardAction {

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
        takeCart();
        chooseGood();
        //putToCart();
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.printf("%s entered to the Store%n", customer);
    }

    @Override
    public void takeCart(){
        System.out.printf("%s take cart%n", customer);
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
    public int putToCart(Good good){
        return 0;
    }

    @Override
    public void goOut() {
        System.out.printf("%s leaves the Store%n", customer);
    }
}
