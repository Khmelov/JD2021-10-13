package by.it.rudakova.jd02_03.service;

import by.it.rudakova.jd02_03.helper.RandomInt;
import by.it.rudakova.jd02_03.helper.Timeout;
import by.it.rudakova.jd02_03.model.*;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCartAction {

    private final Customer customer;
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
        try {
            manager.semaphore.acquire();
            enteredStore();
            takeCart();
            int productsCount = RandomInt.random(2, 5);
            double totalRevenue = 0;
            for (int i = 0; i < productsCount; i++) {
                Goods product = chooseGood();
                int numberItemsInCart = putToCart(product);
                totalRevenue = totalRevenue + product.getPrice();
                customer.setRevenue(totalRevenue);
                System.out.println("The cart has " + numberItemsInCart + " items");
            }
            goQueue();
            goOut();
            manager.goOutOneCustomer();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            manager.semaphore.release();
        }
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
        customer.setShoppingCart(new ShoppingCart());
        System.out.printf("%s has taken the cart%n", customer);
    }

    @Override
    public int putToCart(Goods good) {
        int timeOut = RandomInt.random(100, 300);
        Timeout.sleep(timeOut);

        if (customer.getShoppingCart() == null) {
            System.out.println("A cart is not taken");
            return 0;
        }
        System.out.println(good + " is added into the cart");
        return customer.getShoppingCart().add(good);
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
