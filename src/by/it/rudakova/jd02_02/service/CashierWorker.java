package by.it.rudakova.jd02_02.service;

import by.it.rudakova.jd02_02.helper.RandomInt;
import by.it.rudakova.jd02_02.helper.Timeout;
import by.it.rudakova.jd02_02.model.Cashier;
import by.it.rudakova.jd02_02.model.Customer;
import by.it.rudakova.jd02_02.model.Manager;
import by.it.rudakova.jd02_02.model.Queue;

public class CashierWorker implements Runnable{

    private Manager manager;

    private Queue queue;

    private Cashier cashier;

    public CashierWorker(Manager manager, Queue queue, Cashier cashier){
        this.manager=manager;
        this.queue=queue;
        this.cashier=cashier;
    }

    @Override
    public void run() {
        System.out.println(cashier+" is opened");
        while (!manager.storeIsClosed()){
            Customer customer=queue.extract();
            if(customer!=null){
                synchronized (customer.getMonitor()){
                    System.out.println(cashier+" has started to serve a "+customer);
                    int timeout= RandomInt.random(2000, 5000);
                    double currentRevenue=cashier.getRevenue();
                    currentRevenue+=customer.getRevenue();
                    cashier.setRevenue(currentRevenue);
                    Timeout.sleep(timeout);
                    customer.setWaiting(false);
                    customer.notify();
                    System.out.println(cashier+" has finished to serve a "+customer);
                }
            }else {
                Timeout.sleep(10);
            }
        }

        System.out.println(cashier+" has closed, REVENUE is "+cashier.getRevenue());

    }
}
