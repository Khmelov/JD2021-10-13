package by.it.ena.jd02_03.service;

import by.it.ena.jd02_03.helper.RandomInt;
import by.it.ena.jd02_03.helper.Timeout;
import by.it.ena.jd02_03.model.Cashier;
import by.it.ena.jd02_03.model.Customer;
import by.it.ena.jd02_03.model.Manager;
import by.it.ena.jd02_03.model.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Store extends Thread {

    private final Manager manager;
    private final Queue queue = new Queue();
    private final Semaphore semaphore = new Semaphore(20);

    public Store(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public Queue getQueue() {
        return queue;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

}
