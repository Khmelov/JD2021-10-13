package by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients;

import by.it.shcharbunou.jd02_02.multithreaded_store.exceptions.StoreException;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {

    private final BlockingDeque<Customer> queue = new LinkedBlockingDeque<>(45);

    public void add(Customer customer) {
        try {
            queue.putLast(customer);
        } catch (InterruptedException e) {
            throw new StoreException("Error: Interrupted.", e);
        }
    }

    public int getSize() {
        return queue.size();
    }

    public Customer extract() {
        return queue.pollFirst();
    }
}
