package by.it.karmyzov.Test.MultiThreadimg;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);
       new Person("Zaur", callBox);
       new Person("Oleg", callBox);
       new Person("Elena", callBox);
       new Person("Victor", callBox);
       new Person("Marina", callBox);

    }
}
class Person extends Thread {
    String name;
    private Semaphore callBox;
    public  Person (String name, Semaphore callBox){
        this.name=name;
        this.callBox=callBox;
        this.start();

    }
    public void run() {

        try {
            System.out.println(name +" wait...");
            callBox.acquire();
            System.out.println(name + " пользуется телефоном");
            sleep(2000);
            System.out.println(name + " завершил звонок");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            callBox.release();
        }
    }
}