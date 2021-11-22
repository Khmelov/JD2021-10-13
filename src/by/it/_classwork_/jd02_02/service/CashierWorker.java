package by.it._classwork_.jd02_02.service;

import by.it._classwork_.jd02_02.helper.RandomInt;
import by.it._classwork_.jd02_02.helper.Timeout;
import by.it._classwork_.jd02_02.model.Casheir;
import by.it._classwork_.jd02_02.model.Customer;
import by.it._classwork_.jd02_02.model.Manager;
import by.it._classwork_.jd02_02.model.Queue;

public class CashierWorker implements Runnable {

    private final Manager manager;

    private final Queue queue;

    private final Casheir casheir;

    public CashierWorker(Manager manager, Queue queue, Casheir casheir) {
        this.manager = manager;
        this.queue = queue;
        this.casheir = casheir;
    }

    @Override
    public void run() {
        System.out.printf("\t%s opened -----------%n", casheir);
        while (!manager.storeIsClosed()) {
            Customer customer = queue.extract();
            if (customer != null) {
                synchronized (customer.getMonitor()) {
                    System.out.printf("\t%s started service for %s%n", casheir, customer);
                    int timeout = RandomInt.random(2000, 5000);
                    double currentTotal = casheir.getTotal();
                    currentTotal+=customer.getTotal();
                    casheir.setTotal(currentTotal);
                    Timeout.sleep(timeout);
                    customer.setWaiting(false);
                    customer.notify();
                    System.out.printf("\t%s finished service for %s%n", casheir, customer);
                }
            } else {
                Timeout.sleep(10); //prod-cons
            }
        }
        System.out.printf("\t%s closed TOTAL %f%n", casheir, casheir.getTotal());
    }
}
