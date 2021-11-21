package by.it.rudakova.jd02_01.service;

import by.it.rudakova.jd02_01.helper.RandomInt;
import by.it.rudakova.jd02_01.helper.Timeout;
import by.it.rudakova.jd02_01.model.Customer;
import by.it.rudakova.jd02_01.model.Goods;
import by.it.rudakova.jd02_01.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCartAction {

    private final Customer customer;
    private ShoppingCart cartForCustomer;

    public CustomerWorker() {
        throw new StoreException("not a customer");
    }

    public CustomerWorker(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int productsCount = RandomInt.random(2, 5);
        for (int i = 0; i < productsCount; i++) {
            Goods product = chooseGood();
            int numberItemsInCart = putToCart(product);
            System.out.println("The cart has " + numberItemsInCart + " items");
        }
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.printf("%s has entered to the store%n", customer);
    }

    @Override
    public Goods chooseGood() {
        Goods good = GoodsProducer.getInstance().random();
        int timeOut = RandomInt.random(500, 2000);
        Timeout.sleep(timeOut);
        System.out.printf("%s has chosen %s%n", customer, good);
        return good;
    }

    @Override
    public void goOut() {
        System.out.printf("%s has left the Store%n", customer);
    }

    @Override
    public void takeCart() {
        int timeOut = RandomInt.random(100, 300);
        Timeout.sleep(timeOut);
        cartForCustomer = new ShoppingCart();
        System.out.printf("%s has taken the cart%n", customer);
    }

    @Override
    public int putToCart(Goods good) {
        int timeOut = RandomInt.random(100, 300);
        Timeout.sleep(timeOut);

        if (cartForCustomer == null) {
            System.out.println("A cart is not taken");
            return 0;
        }
        System.out.println(good + " is added into the cart");
        return cartForCustomer.add(good);
    }
}
