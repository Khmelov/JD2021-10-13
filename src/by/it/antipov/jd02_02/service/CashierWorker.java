package by.it.antipov.jd02_02.service;

import by.it.antipov.jd02_02.Helper.Randomizer;
import by.it.antipov.jd02_02.model.*;

import java.util.List;
import java.util.Map;

public class CashierWorker implements Runnable {
    Cashier cashier;
   // CustomerWorker customerWorker;
    Queue queue;
    Manager manager;

   public CashierWorker(Cashier cashier,Manager manager,Queue queue){
       this.cashier=cashier;this.manager=manager;this.queue=queue;}


    @Override
    public void run() {
        System.out.println(cashier + "is working");
        while (!manager.storeIsClosed()) {
            Customer customer = queue.extractCustomer();
            if (customer != null) {
                synchronized (customer.getMonitor()) {
                   System.out.println("Cashier logic");
                    double bill = 0;
                   double revenue = cashier.getRevenue();
                  StringBuffer goods = new StringBuffer();
                    for (Good good : customer.getCustomerCart().getCart()) {
                        bill = bill + good.getPrice();
                        goods.append("," + good.getName());
                    }
                    revenue = revenue + bill;
                    cashier.setRevenue(revenue);
                    System.out.println("Goods:" + goods + "\n" + "bill:" + bill + "\n" + "current revenue of the cashier:"+cashier+" "+ revenue);
                    try {
                        Thread.sleep(Randomizer.Randomizer(20, 50));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
