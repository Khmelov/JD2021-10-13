package by.it.malyshchik.jd02_03.model;

import java.util.concurrent.Semaphore;

public class Store {

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
