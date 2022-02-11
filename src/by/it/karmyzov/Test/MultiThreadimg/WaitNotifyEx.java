package by.it.karmyzov.Test.MultiThreadimg;

public class WaitNotifyEx {
    public static void main(String[] args) {
        Market market = new Market();
        Produser produser = new Produser(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(produser);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();

    }
}

class Market {
    private int breadCount = 0;

    public synchronized void gedBread() {
        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("Потребитель купил один хлеб");
        System.out.println("Количество хлеба в магазине =" + breadCount);
        notify();
    }

    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину один хлеб");
        System.out.println("Количество хлеба в магазине =" + breadCount);
        notify();
    }
}

class Produser implements Runnable {
    Market market;

    public Produser(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();

        }

    }
}

class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.gedBread();
        }
    }
}