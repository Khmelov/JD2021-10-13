package by.it.oliakhevich.jd02_01.helperstore;

import java.util.Random;

public class RandomInt {
    private static final Random generator = new Random();

    public static int random(int min, int max) {
        return generator.nextInt(max - min + 1) + min;
    }

}
