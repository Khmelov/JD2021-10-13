package by.it.rudakova.jd02_02.service;

import by.it.rudakova.jd02_02.helper.RandomInt;
import by.it.rudakova.jd02_02.helper.Timeout;
import by.it.rudakova.jd02_02.model.*;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCartAction {

    private final Customer customer;
    private ShoppingCart cartForCustomer;
    private final Manager manager;
    private final Queue queue;

    public CustomerWorker(Customer customer,Manager manager, Queue queue) {
        this.customer=customer;
        this.manager = manager;
        this.queue=queue;
        manager.addOneCustomer();
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
        customer.setRevenue(chooseGood().getPrice());
        goQueue();
        goOut();
        manager.goOutOneCustomer();
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

    @Override
    public void goQueue() {
        synchronized (customer){
            System.out.println(customer+" went to the queue");
            queue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting())
                try{
                    customer.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            System.out.println(customer+" has left the queue");
        }
    }
}
