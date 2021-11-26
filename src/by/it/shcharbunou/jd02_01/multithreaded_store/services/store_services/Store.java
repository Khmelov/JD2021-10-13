package by.it.shcharbunou.jd02_01.multithreaded_store.services.store_services;

import by.it.shcharbunou.jd02_01.multithreaded_store.entities.clients.Customer;
import by.it.shcharbunou.jd02_01.multithreaded_store.exceptions.SuspenderException;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.customer_services.CustomerWorker;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.customer_services.PensionerWorker;
import by.it.shcharbunou.jd02_01.multithreaded_store.services.customer_services.StudentWorker;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Randomizer;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Suspender;
import by.it.shcharbunou.jd02_01.multithreaded_store.utils.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Store implements Runnable {

    private final Randomizer randomizer = new Randomizer();
    private final Timer timer = new Timer();
    private final Suspender suspender = new Suspender();

    @Override
    public synchronized void run() {
        System.out.println("Store is opened!");
        List<Thread> threads = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        long workingTime = TimeUnit.MINUTES.toMillis(2);
        long endTime;
        int customersCount;
        long startMinute = System.currentTimeMillis();
        long endMinute = System.currentTimeMillis();
        do {
            int secondInOneMinuteCount = (int) (endMinute - startMinute)  / 1000;
            if (secondInOneMinuteCount < 30) {
                customersCount = secondInOneMinuteCount + 10;
            } else if (secondInOneMinuteCount < 60) {
                customersCount = 40 + 30 - secondInOneMinuteCount;
            } else {
                startMinute = System.currentTimeMillis();
                secondInOneMinuteCount = (int) (endMinute - startMinute)  / 1000;
                customersCount = secondInOneMinuteCount + 10;
            }
            for (int i = 0; i < customersCount - threads.size(); i++) {
                int chance;
                chance = randomizer.randomize(1, 4);
                if (chance == 1) {
                    Customer pensioner = new Customer(randomizer.randomize());
                    Thread pensionerThread = new Thread(new PensionerWorker(pensioner));
                    threads.add(pensionerThread);
                    pensionerThread.start();
                } else if (chance == 2 || chance == 3) {
                    Customer student = new Customer(randomizer.randomize());
                    Thread studentThread = new Thread(new StudentWorker(student));
                    threads.add(studentThread);
                    studentThread.start();
                } else {
                    Customer customer = new Customer(randomizer.randomize());
                    Thread customerThread = new Thread(new CustomerWorker(customer));
                    threads.add(customerThread);
                    customerThread.start();
                }
            }
            endTime = System.currentTimeMillis();
            endMinute = System.currentTimeMillis();
            suspender.suspend(1000);
            threads.removeIf(thread -> thread.getState() == Thread.State.TERMINATED);
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
