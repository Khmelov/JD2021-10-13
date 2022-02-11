package by.it.ena.jd02_03.service;


import by.it.ena.jd02_03.helper.RandomInt;
import by.it.ena.jd02_03.helper.Timeout;
import by.it.ena.jd02_03.model.Cashier;
import by.it.ena.jd02_03.model.Customer;
import by.it.ena.jd02_03.model.Manager;
import by.it.ena.jd02_03.model.Queue;

public class CashierWorker implements Runnable {

    private final Manager manager;

    private final Queue queue;

    private final Cashier cashier;

    public CashierWorker(Cashier cashier, Store store) {
        this.manager = store.getManager();
        this.queue = store.getQueue();
        this.cashier = cashier;
    }

    @Override
    public void run() {
        System.out.printf("\t%s opened %n", cashier);
        while (!manager.storeIsClosed()) {
            Customer customer = queue.extract();
            if (customer != null) {
                synchronized (customer.getMonitor()) {
                    System.out.printf("\t%s started service for %s%n", cashier, customer);
                    int timeout = RandomInt.random(2000, 5000);
                    double currentTotal = cashier.getTotal();
                    currentTotal += customer.getTotal();
                    cashier.setTotal(currentTotal);
                    Timeout.sleep(timeout);
                    customer.setWaiting(false);
                    customer.notify();
                    System.out.printf("\t%s finished service for %s%n", cashier, customer);
                }
            } else {
                Timeout.sleep(10);
            }
        }
        System.out.printf("\t%s closed TOTAL %f%n", cashier, cashier.getTotal());
    }
}
