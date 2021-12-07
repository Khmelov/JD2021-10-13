package by.it.ena.jd02_02.service;

import by.it.ena.jd02_02.helper.RandomInt;
import by.it.ena.jd02_02.helper.Timeout;
import by.it.ena.jd02_02.model.Cashier;
import by.it.ena.jd02_02.model.Customer;
import by.it.ena.jd02_02.model.Manager;
import by.it.ena.jd02_02.model.Queue;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {

    private final Manager manager;
    private final Queue queue = new Queue();

    public Store(Manager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized void start() {
        System.out.println("Store opened");
        int number = 0;
        List<Thread> threads = new ArrayList<>();

        for (int numberCasier = 1; numberCasier <= 2; numberCasier++) {
            Cashier casheir = new Cashier(numberCasier);
            CashierWorker cashierWorker = new CashierWorker(manager, queue, casheir);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }

        while (manager.storeIsOpened()) {
            int count = RandomInt.random(0, 2);
            for (int i = 0; manager.storeIsOpened() && i < count; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerThead = new CustomerWorker(customer, manager, queue);
                threads.add(customerThead);
                customerThead.start();
            }
            Timeout.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreException("Interrupted", e);
            }
        }

        System.out.println("Store closed");
    }
}
