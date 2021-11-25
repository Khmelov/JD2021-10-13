package by.it.karmyzov.Test.MultiThreadimg;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
   static CountDownLatch countDownLatch = new CountDownLatch(3);

   private static void marketStuffisOnPlace() throws InterruptedException {
       Thread.sleep(2000);
       System.out.println("market stuff came to work");
       countDownLatch.countDown();
       System.out.println("countDownLatch = " + countDownLatch.getCount()  );
   }
    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("все готово давайте открывать магазин");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount()  );
    }
    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("магазин открыt");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount()  );
    }
    public static void main(String[] args) throws InterruptedException {
       new Friend("Zaur", countDownLatch);
       new Friend("Oleg", countDownLatch);
       new Friend("Elena", countDownLatch);
       new Friend("Victor", countDownLatch);
       new Friend("Marina", countDownLatch);
       marketStuffisOnPlace();
       everythingIsReady();
       openMarket();


    }
}
class Friend  extends Thread{
    String name;
    private CountDownLatch countDownLatch;
    public Friend(String name, CountDownLatch countDownLatch) {
        this.name=name;
        this.countDownLatch = countDownLatch;
        this.start();
    }
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + "приступил а к закупками");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
