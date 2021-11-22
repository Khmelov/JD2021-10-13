package by.it.karmyzov.jd02_03.service;


import by.it.karmyzov.jd02_03.helper.RandomInt;
import by.it.karmyzov.jd02_03.helper.Timeout;
import by.it.karmyzov.jd02_03.model.Casheir;
import by.it.karmyzov.jd02_03.model.Customer;
import by.it.karmyzov.jd02_03.model.Manager;
import by.it.karmyzov.jd02_03.model.Queue;
import by.it.karmyzov.jd02_03.service.CashierWorker;
import by.it.karmyzov.jd02_03.service.CustomerWorker;
import by.it.karmyzov.jd02_03.service.StoreExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Store extends Thread {
    private final Manager manager;
    private final Queue queue = new Queue();
    private final Semaphore semaphore = new Semaphore(20);

    public Manager getManager() {
        return manager;
    }

    public Queue getQueue() {
        return queue;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public Store(Manager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized void start() {
        System.out.println("Store opened");
        int number = 0;
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        for (int nubmerCashier = 1; nubmerCashier <= 2; nubmerCashier++) {
            Casheir casheir = new Casheir(nubmerCashier);
            CashierWorker cashierWorker = new CashierWorker(manager, queue, casheir);
            fixedThreadPool.execute(cashierWorker);
        }
        fixedThreadPool.shutdown();
        while (manager.storeIsOpened()) {
            int count = RandomInt.random(0, 2);
            for (int i = 0; manager.storeIsOpened() && i < count; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerThread = new CustomerWorker(customer, this);

                customerThread.start();
            }
            Timeout.sleep(1000);
        }
        while (!fixedThreadPool.isTerminated()) {
            Thread.onSpinWait();

        }
        System.out.println("Store closed");
    }
    }

