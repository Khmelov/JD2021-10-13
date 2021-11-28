package by.it.karmyzov.Test.MultiThreadimg;

public class VolatilesEx extends Thread {
  volatile  boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;

        }
        System.out.println("Loop is finished =" + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatilesEx thread = new VolatilesEx();
        thread.start();
        Thread.sleep(3000);
        System.out.println("After 3 srconds it is time to wake up!");
        thread.b = false;
        thread.join();
        System.out.println("end of programm");


    }

}
