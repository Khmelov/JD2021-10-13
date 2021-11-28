package by.it.karmyzov.jd02_03.service;

import by.it.karmyzov.jd02_03.helper.RandomInt;
import by.it.karmyzov.jd02_03.helper.Timeout;
import by.it.karmyzov.jd02_03.model.Casheir;
import by.it.karmyzov.jd02_03.model.Customer;
import by.it.karmyzov.jd02_03.model.Store;

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

        for (int nubmerCashier = 1; nubmerCashier <= 2; nubmerCashier++) {
            Casheir casheir = new Casheir(nubmerCashier);
            CashierWorker cashierWorker = new CashierWorker(casheir, store);
            fixedThreadPool.execute(cashierWorker);
        }
        fixedThreadPool.shutdown();

        while (store.getManager().storeIsOpened()) {
            int count = RandomInt.random(0, 2);
            for (int i = 0; store.getManager().storeIsOpened() && i < count; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerThread = new CustomerWorker(customer, store);
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


