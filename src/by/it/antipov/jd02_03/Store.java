package by.it.antipov.jd02_03;



import by.it.antipov.jd02_03.model.Cashier;
import by.it.antipov.jd02_03.model.Customer;
import by.it.antipov.jd02_03.model.Manager;
import by.it.antipov.jd02_03.model.Queue;
import by.it.antipov.jd02_03.service.CashierWorker;
import by.it.antipov.jd02_03.service.CustomerWorker;
import by.it.antipov.jd02_03.service.StoreException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Store extends Thread{
    Manager manager;
    Queue queue=new Queue();
    Semaphore semaphore = new Semaphore(20);


    public Store(Manager manager) {
        this.manager = manager;
    }
    @Override
    synchronized public void start() {
        System.out.println("Store opened");
        int number=0;
        Random random = new Random();
        List<Thread> threads=new ArrayList<>();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier =new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier,manager,queue);
            fixedThreadPool.execute(cashierWorker);
        }
        fixedThreadPool.shutdown();



        while (manager.storeIsOpened()) {
            for (int i = 0; i <random.nextInt(2) ; i++) {
                Customer customer=new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(customer,queue,manager,semaphore);
                threads.add(customerWorker);
                customerWorker.start();
                try {
                    Thread.sleep(100);
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
        while (!fixedThreadPool.isTerminated()) {
            Thread.onSpinWait();
        }
        System.out.println("Store closed");
    }
}
