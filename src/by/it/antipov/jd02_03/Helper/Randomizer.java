package by.it.antipov.jd02_03.Helper;

import java.util.Random;

public class Randomizer {
    public static int Randomizer(int min,int max){
        Random  random=new Random();
        return min+random.nextInt(max-min);
    }
}
