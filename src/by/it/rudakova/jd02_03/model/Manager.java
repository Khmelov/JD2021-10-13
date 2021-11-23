package by.it.rudakova.jd02_03.model;

import by.it.rudakova.jd02_03.Constants;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    public final Semaphore semaphore=new Semaphore(Constants.PERMITS);

    private final AtomicInteger countIn=new AtomicInteger(0);

    public final AtomicInteger countOut=new AtomicInteger(0);

    private final int PLAN;

    public Manager(int PLAN) {
        this.PLAN = PLAN;
    }

   public void addOneCustomer(){
        countIn.getAndIncrement();
    }

   public  void goOutOneCustomer(){
        countOut.getAndIncrement();
    }

    public boolean storeIsOpened(){
        return PLAN!=countIn.get();
    }

   public boolean storeIsClosed(){
        return PLAN==countOut.get();
    }
}
