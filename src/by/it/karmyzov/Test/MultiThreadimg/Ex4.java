package by.it.karmyzov.Test.MultiThreadimg;

public class Ex4 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("HI");
            }
        }).start();
        new Thread(() -> System.out.println("HI you")).start();
    }

}

