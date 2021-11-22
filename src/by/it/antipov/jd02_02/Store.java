package by.it.antipov.jd02_02;


import by.it.antipov.jd02_02.model.Cashier;
import by.it.antipov.jd02_02.model.Customer;
import by.it.antipov.jd02_02.service.CashierWorker;
import by.it.antipov.jd02_02.service.CustomerWorker;
import by.it.antipov.jd02_02.service.StoreException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store extends Thread{
    @Override
    synchronized public void start() {
        System.out.println("Store opened");
        int number=0;
        Random random = new Random();
        List<Thread> threads=new ArrayList<>();
        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier =new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }



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
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreException("Interrupted");
            }
        }

        System.out.println("Store closed");
    }
}
