package by.it.shcharbunou.jd02_03.multithreaded_store.entities.inventory;

import by.it.shcharbunou.jd02_03.multithreaded_store.entities.inventory.ShoppingCart;
import by.it.shcharbunou.jd02_03.multithreaded_store.exceptions.StoreException;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ShoppingCartsQueue {

    private final BlockingDeque<ShoppingCart> queue = new LinkedBlockingDeque<>(50);

    public void add(ShoppingCart shoppingCart) {
        try {
            queue.putLast(shoppingCart);
        } catch (InterruptedException e) {
            throw new StoreException("Error: Interrupted.", e);
        }
    }

    public int getSize() {
        return queue.size();
    }

    public ShoppingCart extract() {
        return queue.pollFirst();
    }
}
