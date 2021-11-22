package by.it.karmyzov.Test.MultiThreadimg;

public class Ex12 {
    static final Object lock= new Object();

    void mobileCall() {
        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");
        }
    }
 void skypeCall () {
     synchronized (lock) {
         System.out.println("Skype call starts");
         try {
             Thread.sleep(5_000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("Skype call ends");
     }
        }

 void whatsUpCall () {
     synchronized (lock) {

         System.out.println("whatsUp call starts");
         try {
             Thread.sleep(7_000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("whatsUp call ends");
     }
 }
        public static void main (String[]args){
            Thread thread1 = new Thread(new RunnableImpMobile());
            Thread thread2 = new Thread(new RunnableImpSkype());
            Thread thread3 = new Thread(new RunnableImpWhatsUp());
            thread1.start();
            thread2.start();
            thread3.start();

        }
    }

    class RunnableImpMobile implements Runnable {
        @Override
        public void run() {
            new Ex12().mobileCall();
        }
    }

    class RunnableImpSkype implements Runnable {
        @Override
        public void run() {
            new Ex12().skypeCall();
        }
    }

    class RunnableImpWhatsUp implements Runnable {
        @Override
        public void run() {
            new Ex12().whatsUpCall();
        }
    }

