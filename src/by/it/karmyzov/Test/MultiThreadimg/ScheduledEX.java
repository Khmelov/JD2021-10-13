package by.it.karmyzov.Test.MultiThreadimg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledEX {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);
//        for (int i = 0; i <10 ; i++) {
// scheduledExecutorService.execute(new RunnebleImp200());
//        }
//
        scheduledExecutorService.scheduleAtFixedRate(new RunnebleImp200(),
                3,1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(new RunnebleImp200(),
                3,1,TimeUnit.SECONDS);
        Thread.sleep(20000);
        scheduledExecutorService.shutdown();

        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
class RunnebleImp200 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}