package by.it.karmyzov.Test.MultiThreadimg;
public class Ex10 {
    public static synchronized void main(String[] args) {
        MyrunnebleImpl1 myrunnebleImpl1 = new MyrunnebleImpl1();
        Thread thread1 = new Thread(myrunnebleImpl1);
        Thread thread2 = new Thread(myrunnebleImpl1);
        Thread thread3 = new Thread(myrunnebleImpl1);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
class Counter {
    static int count = 0;
}
class MyrunnebleImpl1 implements Runnable {
public synchronized void increment () {
    Counter.count++;
    System.out.print(Counter.count + " ");
}
    @Override
    public void run() {
        for (int i = 0; i <3; i++) {
            increment();

        }
    }
}
