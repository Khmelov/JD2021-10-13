package by.it.malyshchik.jd02_02.model;

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
        return PLAN!=countIn; //volatile
    }

    public boolean storeIsClosed(){ //volatile
        return PLAN==countOut;
    }
}
