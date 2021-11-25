package by.it.shcharbunou.jd02_01.multithreaded_store.services.store_services;

import by.it.shcharbunou.jd02_01.multithreaded_store.entities.clients.Customer;
import by.it.shcharbunou.jd02_01.multithreaded_store.exceptions.SuspenderException;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.customer_services.CustomerWorker;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Randomizer;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Suspender;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Timer;

import java.util.ArrayList;
import java.util.List;

public class Store implements Runnable {

    private final Randomizer randomizer = new Randomizer();
    private final Timer timer = new Timer();
    private final Suspender suspender = new Suspender();

    @Override
    public synchronized void run() {
        System.out.println("Store is opened!");
        List<Thread> threads = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        long workingTime = 120 * 1_000;
        long endTime;
        int customersCount;
        do {
            customersCount = randomizer.randomize(0, 2);
            for (int i = 0; i < customersCount; i++) {
                Customer customer = new Customer(randomizer.randomize());
                Thread customerThread = new Thread(new CustomerWorker(customer));
                threads.add(customerThread);
                customerThread.start();
            }
            endTime = System.currentTimeMillis();
            suspender.suspend(1000);
        } while (timer.isRunning(startTime, endTime, (int) workingTime));
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new SuspenderException("Error: Thread interrupted.", e);
            }
        }
        System.out.println("Store is closed!");
    }
}
