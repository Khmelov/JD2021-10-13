package by.it.oliakhevich.jd02_01;

import by.it.oliakhevich.jd02_01.helperstore.RandomInt;
import by.it.oliakhevich.jd02_01.model.Customer;
import by.it.oliakhevich.jd02_01.helperstore.Timeout;
import by.it.oliakhevich.jd02_01.service.StoreException;
import by.it.oliakhevich.jd02_01.service.CustomerWorker;
import by.it.oliakhevich.jd02_03.model.Manager;

import java.util.ArrayList;
import java.util.List;


public class Store extends Thread {
    public Store(Manager manager) {
    }

    @Override
    public synchronized void start() {
        System.out.println("Store open");
        int number = 0;
        List<CustomerWorker> threads = new ArrayList<>();
        for (int second = 0; second < 100; second++) {
            int count = RandomInt.random(0, 2);
            for (int i = 0; i < count; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerThead = new CustomerWorker(customer);
                threads.add(customerThead);
                customerThead.start();
            }
            Timeout.sleep(1000);
        }

        for (CustomerWorker thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreException("Interrupted", e);
            }

        }
        System.out.println("Store closed");

    }


}
