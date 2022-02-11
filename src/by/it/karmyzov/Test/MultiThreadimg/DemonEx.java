package by.it.karmyzov.Test.MultiThreadimg;

public class DemonEx {
    public static void main(String[] args) {
        System.out.println("main thread starts");
        UserThread userThread = new UserThread();
        userThread.setName("user thread");
        DeamonThread deamonThread = new DeamonThread();
        deamonThread.setName("deamon thread");
        deamonThread.setDaemon(true);
        userThread.start();
        deamonThread.start();
        System.out.println("main thread end");



        System.out.println("main thread starts");
    }
}


class UserThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is deamon: " + isDaemon());
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class DeamonThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is deamon: " + isDaemon());
        for (int i = 1; i <= 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}