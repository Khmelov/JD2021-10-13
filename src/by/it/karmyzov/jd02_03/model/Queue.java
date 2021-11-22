package by.it.karmyzov.jd02_03.model;

import by.it.karmyzov.jd02_03.Constans;
import by.it.karmyzov.jd02_03.service.StoreExeption;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {
    private final Object monitorQueue = new Object();

    private final BlockingDeque<Customer> queue = new LinkedBlockingDeque<>(Constans.Q_CAPACITY);

    public void add(Customer customer) {

        try {
            queue.putLast(customer);
        } catch (InterruptedException e) {
          throw  new StoreExeption("Queue Interrupt", e);
        }
    }
    public Customer extract () {
        return queue.pollFirst();
        }
    }
