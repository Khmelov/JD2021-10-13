package by.it.karmyzov.jd02_03.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private final AtomicInteger countIn = new AtomicInteger(0);
    private final AtomicInteger countOut = new AtomicInteger(0);
    private final int PlAN;

    public Manager(int PlAN) {
        this.PlAN = PlAN;
    }

    public void addOneCustomer() {
        countIn.getAndDecrement();
    }

    public void goOutOneCustomer() {
        countOut.getAndIncrement();
    }

    public boolean storeIsOpened() {
        return PlAN != countIn.get();
    }

    public boolean storeIsClosed() {
        return PlAN == countOut.get();
    }
}
