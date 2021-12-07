package by.it.ena.jd02_03.service;

import by.it.ena.jd02_03.helper.RandomInt;
import by.it.ena.jd02_03.helper.Timeout;
import by.it.ena.jd02_03.model.Cashier;
import by.it.ena.jd02_03.model.Customer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StoreWorker extends Thread {

    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void start() {
        System.out.println("Store opened");
        int number = 0;

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        for (int numberCasier = 1; numberCasier <= 2; numberCasier++) {
            Cashier cashier = new Cashier(numberCasier);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            fixedThreadPool.execute(cashierWorker);
        }
        fixedThreadPool.shutdown();

        while (store.getManager().storeIsOpened()) {
            int count = RandomInt.random(0, 2);
            for (int i = 0; store.getManager().storeIsOpened() && i < count; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerThead = new CustomerWorker(customer, store);
                customerThead.start();
            }
            Timeout.sleep(1000);
        }

        while (!fixedThreadPool.isTerminated()) {
            Thread.onSpinWait();
        }
        System.out.println("Store closed");
    }
}
