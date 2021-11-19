package by.it.karmyzov.Test.MultiThreadimg;

public class Ex5 {
    public static void main(String[] args) {
MyThread5 thread5 = new MyThread5();
thread5.setName("Moi Potok");
thread5.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name : " + thread5.getName() +
                           " Priority:" +   thread5.getPriority());

    }



}
 class MyThread5 extends Thread {
     @Override
     public void run() {
         System.out.println("Hi you");
     }
 }
