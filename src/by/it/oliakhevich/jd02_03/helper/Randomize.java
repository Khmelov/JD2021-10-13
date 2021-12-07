package by.it.oliakhevich.jd02_03.helper;

import java.util.Random;

public class Randomize {
    public static int Randomize(int min,int max){
        Random  random=new Random();
        return min+random.nextInt(max-min);
    }
}
