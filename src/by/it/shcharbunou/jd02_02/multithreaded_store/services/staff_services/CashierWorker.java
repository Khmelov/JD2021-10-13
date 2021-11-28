package by.it.shcharbunou.jd02_02.multithreaded_store.services.staff_services;

import by.it.shcharbunou.jd02_01.multithreaded_store.exceptions.CustomerException;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients.Customer;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients.Queue;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.staff.Cashier;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Manager;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Randomizer;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Suspender;

import java.math.BigDecimal;

public class CashierWorker implements Runnable {

    private final Manager manager;
    private final Queue queue;
    private final Cashier cashier;
    private final Suspender suspender = new Suspender();
    private final Randomizer randomizer = new Randomizer();

    public CashierWorker(Manager manager, Queue queue, Cashier cashier) {
        this.manager = manager;
        this.queue = queue;
        this.cashier = cashier;
        cashier.setProfit(new BigDecimal(0));
    }

    @Override
    public void run() {
        System.out.printf("-----%s is opened-----\n", cashier.getName());
        while (manager.storeIsOpened()) {
            Customer customer = queue.extract();
            if (customer != null) {
                synchronized (customer.getMonitor()) {
                    System.out.printf("%s serves customer[%d] (%s) now...\n", cashier.getName(), customer.getId(),
                            customer);
                    cashier.setProfit(cashier.getProfit().add(customer.getProfit()));
                    System.out.printf("Customer[%d] paid a check for %s...\n", customer.getId(),
                            customer.getProfit().toString());
                    suspender.suspend(randomizer.randomize(2000, 5000));
                    customer.setWaiting(false);
                    customer.notify();
                    System.out.printf("%s stopped service customer[%d] (%s)...\n", cashier.getName(), customer.getId(),
                            customer);
                }
            }
        }
        System.out.printf("-----%s is closed-----\nPROFIT: %s\n", cashier.getName(), cashier.getProfit().toString());
    }
}
