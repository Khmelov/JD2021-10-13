package by.it.shcharbunou.jd02_02.multithreaded_store.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final AtomicInteger countIn;

    private final AtomicInteger countOut;

    private final int plan;

    public Manager(int plan) {
        countIn = new AtomicInteger(0);
        countOut = new AtomicInteger(0);
        this.plan = plan;
    }

    public void addOneCustomer() {
        countIn.getAndIncrement();
    }

    public void goOutOneCustomer() {
        countOut.getAndIncrement();
    }

    public boolean storeIsOpened() {
        return plan != countIn.get();
    }

    public boolean storeIsClosed() {
        return plan == countOut.get();
    }
}
