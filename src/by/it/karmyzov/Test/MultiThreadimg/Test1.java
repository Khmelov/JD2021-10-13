package by.it.karmyzov.Test.MultiThreadimg;

public class Test1 implements Runnable {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);

        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread (new Test1());
        thread1.start();
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}

//        MyThread1 myThread1 = new MyThread1();
//        MyThread2 myThread2 = new MyThread2();
//        myThread1.start();
//        myThread2.start();
//    }
//
//}

//class MyThread1 extends Thread {
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(i);
//
//        }
//    }
//}
//class MyThread2 extends Thread {
//    public void run() {
//        for (int i = 1000; i >0; i--) {
//            System.out.println(i);
//
//        }
//    }
//}