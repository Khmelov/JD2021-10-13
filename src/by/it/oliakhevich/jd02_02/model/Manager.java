package by.it.oliakhevich.jd02_02.model;

public class Manager {
    private volatile int countIn;

    private volatile int countOut;

    private final int PLAN;

    public Manager(int PLAN) {
        this.PLAN = PLAN;
    }

    public synchronized void addOneCustomer(){
        countIn++;
    }

    public synchronized void goOutOneCustomer(){
        countOut++;
    }

    public boolean storeIsOpened(){
        return PLAN!=countIn;
    }

    public boolean storeIsClosed(){
        return PLAN==countOut;
    }
}
