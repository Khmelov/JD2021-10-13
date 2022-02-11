package by.it.karmyzov.Test.MultiThreadimg;

public class Ex9 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Work main begins");
    Thread thread = new Thread(new Worker());
        System.out.println(thread.getState());
    thread.start();
        System.out.println(thread.getState());
    thread.join();
        System.out.println(thread.getState());
        System.out.println("Method main end");
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("Work begins");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work end");
    }
}