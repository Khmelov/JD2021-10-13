package by.it.antipov.jd02_02.service;

import by.it.antipov.jd02_02.Helper.Randomizer;
import by.it.antipov.jd02_02.model.Cashier;
import by.it.antipov.jd02_02.model.Customer;
import by.it.antipov.jd02_02.model.Queue;

import java.util.Map;

public class CashierWorker implements Runnable {
    Cashier cashier;
    CustomerWorker customerWorker;

   public CashierWorker(Cashier cashier){this.cashier=cashier;}


    @Override
    public void run() {
        System.out.println(cashier+"is working");
        Queue queue=new Queue();
Customer customer =queue.extractCustomer();
        if (customer != null) {
           synchronized (customer.getMonitor()) {
            double bill=0;
            double revenue=cashier.getRevenue();
            StringBuilder goods = new StringBuilder();
            Map<String, Double> customerCart = customerWorker.customerCart.cart;
            for (Map.Entry<String, Double> entry:customerCart.entrySet()) {
                bill=bill+entry.getValue();
                goods.append(","+entry.getKey());
            }
            revenue=revenue+bill;
            System.out.println("Goods:"+goods+"\n"+"bill:"+bill+"\n"+"current revenue of the cashier:"+revenue);
            try {
                Thread.sleep(Randomizer.Randomizer(200,500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customer.setWaiting(false);
            customer.notify();}
        }
        else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
