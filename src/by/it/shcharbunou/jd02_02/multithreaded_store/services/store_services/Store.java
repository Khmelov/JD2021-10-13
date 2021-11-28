package by.it.shcharbunou.jd02_02.multithreaded_store.services.store_services;

import by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients.Customer;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients.Pensioner;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients.Queue;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients.Student;
import by.it.shcharbunou.jd02_02.multithreaded_store.entities.staff.Cashier;
import by.it.shcharbunou.jd02_02.multithreaded_store.exceptions.StoreException;
import by.it.shcharbunou.jd02_02.multithreaded_store.services.customer_services.CustomerWorker;
import by.it.shcharbunou.jd02_02.multithreaded_store.services.staff_services.CashierWorker;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Manager;
import by.it.shcharbunou.jd02_02.multithreaded_store.utils.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Store implements Runnable {

    private final Randomizer randomizer = new Randomizer();
    private final Queue queue = new Queue();
    private final Manager manager = new Manager(100);

    @Override
    public synchronized void run() {
        System.out.println("Store is opened!");
        List<Thread> threads = new ArrayList<>();
        List<Thread> cashierThreads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            CashierWorker cashierWorker = new CashierWorker(manager, queue, cashier);
            Thread cashierThread = new Thread(cashierWorker);
            cashierThread.start();
            cashierThreads.add(cashierThread);
        }
        int customersCount;
        long startMinute = System.currentTimeMillis();
        long endMinute = System.currentTimeMillis();
        int customersCounter = 1;
        while (manager.storeIsOpened()){
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
            int threadsCount = customersCount - threads.size();
            for (int i = 0; i < threadsCount; i++) {
                int chance;
                chance = randomizer.randomize(1, 4);
                if (chance == 1) {
                    Customer pensioner = new Pensioner(customersCounter);
                    customersCounter++;
                    Thread pensionerThread = new Thread(new CustomerWorker(pensioner, manager, queue));
                    threads.add(pensionerThread);
                    pensionerThread.start();
                } else if (chance == 2 || chance == 3) {
                    Customer student = new Student(customersCounter);
                    customersCounter++;
                    Thread studentThread = new Thread(new CustomerWorker(student, manager, queue));
                    threads.add(studentThread);
                    studentThread.start();
                } else {
                    Customer customer = new Customer(customersCounter);
                    customersCounter++;
                    Thread customerThread = new Thread(new CustomerWorker(customer, manager, queue));
                    threads.add(customerThread);
                    customerThread.start();
                }
            }
            endMinute = System.currentTimeMillis();
            threads.removeIf(thread -> thread.getState() == Thread.State.TERMINATED);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreException("Error: Thread interrupted.", e);
            }
        }
        for (Thread cashierThread : cashierThreads) {
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                throw new StoreException("Error: Thread interrupted.", e);
            }
        }
        System.out.println("Store is closed!");
    }
}
