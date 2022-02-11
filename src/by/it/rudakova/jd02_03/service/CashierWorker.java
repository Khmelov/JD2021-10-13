package by.it.rudakova.jd02_03.service;

import by.it.rudakova.jd02_03.helper.RandomInt;
import by.it.rudakova.jd02_03.helper.Timeout;
import by.it.rudakova.jd02_03.model.*;

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
                    printReceipt(customer.getShoppingCart(), customer, customer.getRevenue());
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

    private void printReceipt(ShoppingCart cart, Customer customer, double total) {
        System.out.println("The receipt is for "+customer.getName());
       for(Goods product:cart.listGoods){
           System.out.printf("%s: %f; \n",product.getName(),product.getPrice());
       }
        System.out.println("Total: "+total);
    }
}
