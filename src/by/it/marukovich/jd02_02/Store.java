package by.it.marukovich.jd02_02;

import by.it.marukovich.jd02_02.model.Manager;
import by.it.marukovich.jd02_02.model.Queue;
import by.it.marukovich.jd02_02.helper.RandomInt;
import by.it.marukovich.jd02_02.helper.Timeout;
import by.it.marukovich.jd02_02.model.Cashier;
import by.it.marukovich.jd02_02.model.Customer;
import by.it.marukovich.jd02_02.service.CashierWorker;
import by.it.marukovich.jd02_02.service.CustomerWorker;
import by.it.marukovich.jd02_02.service.StoreException;

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

        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(manager, queue, cashier);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }

        while (manager.storeIsOpened()) {
            int count = RandomInt.random(0, 2);
            for (int i = 0; manager.storeIsOpened() && i < count; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerThread = new CustomerWorker(customer, manager, queue);
                threads.add(customerThread);
                customerThread.start();
            }
            Timeout.sleep(1000);
        }

        //waiting
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
