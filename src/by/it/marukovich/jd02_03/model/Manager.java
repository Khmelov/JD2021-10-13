package by.it.marukovich.jd02_03.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final AtomicInteger countIn = new AtomicInteger(0);

    private final AtomicInteger countOut = new AtomicInteger(0);

    private final int PLAN;

    public Manager(int PLAN) {
        this.PLAN = PLAN;
    }

    public void addOneCustomer() {
        countIn.getAndIncrement();
    }

    public void goOutOneCustomer() {
        countOut.getAndIncrement();
    }

    public boolean storeIsOpened() {
        return PLAN != countIn.get();
    }

    public boolean storeIsClosed() {
        return PLAN == countOut.get();
    }
}
