package by.it.antipov.jd02_03.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private AtomicInteger countIn= new AtomicInteger(0);

    private AtomicInteger countOut= new AtomicInteger(0);

    private final int PLAN;

    public Manager(int PLAN) {
        this.PLAN = PLAN;
    }

    public synchronized void addOneCustomer(){
        countIn.getAndIncrement();
    }

    public synchronized void goOutOneCustomer(){
        countOut.getAndIncrement();
    }

    public boolean storeIsOpened(){
        return  PLAN!=countIn.get();
    }

    public boolean storeIsClosed(){
        return PLAN==countOut.get();
    }
}
