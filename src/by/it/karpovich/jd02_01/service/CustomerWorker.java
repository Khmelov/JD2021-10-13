package by.it.karpovich.jd02_01.service;

import by.it.karpovich.jd02_01.helper.RandomInt;
import by.it.karpovich.jd02_01.helper.Timeout;
import by.it.karpovich.jd02_01.model.Customer;
import by.it.karpovich.jd02_01.model.Good;

import java.util.ArrayList;
import java.util.List;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;

    public CustomerWorker() {
        throw new StoreException("not customer");
    }

    public CustomerWorker(Customer customer) {
        this.customer = customer;
    }

    private List<Good> goodList;

    @Override
    public void run() {
        enteredStore();
        takeCart();
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
        System.out.println("Goods in card " + putToCart(good));
        return good;
    }

    @Override
    public void goOut() {
        System.out.printf("%s leaves the Store%n", customer);
    }

    @Override
    public void takeCart() {
        goodList = new ArrayList<>();
    }

    @Override
    public int putToCart(Good good) {
        goodList.add(good);

        return goodList.size();

    }
}
