package by.it.ena.jd02_03.model;

import by.it.ena.jd02_03.service.Constants;
import by.it.ena.jd02_03.service.StoreException;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {

    private final BlockingDeque<Customer> queue = new LinkedBlockingDeque<>(Constants.QUEUE_CAP);

    public final void add(Customer customer) {
        try {
            queue.putLast(customer);
        } catch (InterruptedException e) {
            throw new StoreException("QUEUE_INTERRUPT", e);
        }
    }

    public Customer extract() {
            return queue.pollFirst();
    }


}
