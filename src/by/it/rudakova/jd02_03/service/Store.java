package by.it.rudakova.jd02_03.service;

import by.it.rudakova.jd02_03.Constants;
import by.it.rudakova.jd02_03.service.StoreException;
import by.it.rudakova.jd02_03.helper.RandomInt;
import by.it.rudakova.jd02_03.helper.Timeout;
import by.it.rudakova.jd02_03.model.Cashier;
import by.it.rudakova.jd02_03.model.Customer;
import by.it.rudakova.jd02_03.model.Manager;
import by.it.rudakova.jd02_03.model.Queue;
import by.it.rudakova.jd02_03.service.CashierWorker;
import by.it.rudakova.jd02_03.service.CustomerWorker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Store extends Thread{

    private final Manager manager;
    private final Queue queue=new Queue();

    public Store(Manager manager) {
        this.manager=manager;
    }

    @Override
    public synchronized void start() {
        System.out.println(Constants.STORE_IS_OPENED);
        int number=0;
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        for(int numberCashier=1;numberCashier<=2;numberCashier++){
            Cashier cashier=new Cashier(numberCashier);
            CashierWorker cashierWorker=new CashierWorker(manager,queue,cashier);
           fixedThreadPool.execute(cashierWorker);
        }

        fixedThreadPool.shutdown();


        while(manager.storeIsOpened()){
            int count= RandomInt.random(0,2);
            for(int i=0;manager.storeIsOpened()&&i<count;i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerThread = new CustomerWorker(customer,manager,queue);
                customerThread.start();
            }
            Timeout.sleep(1000);
        }
        while(!fixedThreadPool.isTerminated()){
            Thread.onSpinWait();
        }
        System.out.println(Constants.STORE_IS_CLOSED);
    }
}
