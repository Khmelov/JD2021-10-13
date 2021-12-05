package by.it.ena.jd02_02.model;

import java.util.Deque;
import java.util.LinkedList;

public class Queue {

    private final Object monitorQueue = new Object();

    private final Deque<Customer> queue = new LinkedList<>();

    public final void add(Customer customer) {
        synchronized (monitorQueue) {
            queue.addLast(customer);
        }
    }

    public Customer extract() {
        synchronized (monitorQueue) {
            return queue.pollFirst();
        }
    }


}
