package by.it.malyshchik.jd02_01.helper;

import java.util.Random;

public class RandomInt {
    private final  static Random generator = new Random();
    public static  int random (int min, int max){return generator.nextInt(max - min +1) + min;}
}
