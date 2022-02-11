package by.it.karmyzov.jd02_02.model;

public class Manager {
    private volatile int countIn;
    private volatile int countOut;
    private final int PlAN;

    public Manager (int PlAN) {
        this.PlAN = PlAN;
    }
    public synchronized void addOneCustomer () {
        countIn++;
    }
    public synchronized void goOutOneCustomer () {
        countOut++;
    }
    public boolean storeIsOpened () {
        return PlAN!=countIn;
    }
    public boolean storeIsClosed() {
        return PlAN==countOut;
    }
}
