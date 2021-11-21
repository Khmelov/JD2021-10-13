package by.it.antipov.jd02_01;

import by.it._classwork_.jd02_01.service.StoreException;
import by.it.antipov.jd02_01.model.Customer;
import by.it.antipov.jd02_01.service.CustomerWorker;

import java.util.*;

public class Store extends Thread{
    @Override
    public void start() {
        System.out.println("Store opened");
        int number=0;
        Random random = new Random();
        List<CustomerWorker> threads=new ArrayList<>();
        for (int time = 0; time <12; time++) {
            for (int i = 0; i <random.nextInt(2) ; i++) {
                Customer customer=new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(customer);
                threads.add(customerWorker);
                customerWorker.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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
