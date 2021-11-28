package by.it.karmyzov.jd02_03.service;


import by.it.karmyzov.jd02_03.Constans;
import by.it.karmyzov.jd02_03.helper.RandomInt;
import by.it.karmyzov.jd02_03.helper.Timeout;
import by.it.karmyzov.jd02_03.model.*;

public class CashierWorker implements Runnable {
 private final Manager manager;
 private final Queue queue;
 private final Casheir casheir;

 public CashierWorker (Casheir casheir, Store store) {
     this.manager= store.getManager();
     this.queue = store.getQueue();
     this.casheir = casheir;
 }

    @Override
    public void run() {
        System.out.printf("\t%s opened -------------%n", casheir);
        while (!manager.storeIsClosed()) {
            Customer customer=queue.extract();
            if (customer !=null) {
                synchronized (customer.getMonitor()) {
                    System.out.printf("\t%s started service for %s%n", casheir, customer);
                    int timeout = RandomInt.random(Constans.MIN_CASHIER_TIME, Constans.MAX_CASHIER_TIME);
                    double curentTotal = casheir.getTotal();
                    curentTotal += customer.getTotal();
                    casheir.setTotal(curentTotal);
                    Timeout.sleep(timeout);
                    customer.setWaiting(false);
                    customer.notify();
                    System.out.printf("\t%s finished service for %s%n", casheir, customer);
                }
            }else {
                Timeout.sleep(10);
            }
        }
        System.out.printf("\t%s closed TOTAL %f%n", casheir, casheir.getTotal());
    }
}



