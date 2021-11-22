package by.it.karmyzov.Test.MultiThreadimg;

import java.util.concurrent.*;

public class ThreadpoolEx {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            executorService.execute(new RunnebleImp100());
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS );
        System.out.println("mains end");
    }
}

class RunnebleImp100 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}