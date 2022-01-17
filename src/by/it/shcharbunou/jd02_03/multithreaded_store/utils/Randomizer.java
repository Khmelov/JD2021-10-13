package by.it.shcharbunou.jd02_03.multithreaded_store.utils;

import java.util.Random;

public class Randomizer {

    private final Random random;

    public Randomizer() {
        this.random = new Random();
    }

    public int randomize(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public int randomize() {
        return random.nextInt();
    }

    public int randomize(int max) {
        return random.nextInt(max);
    }

    public boolean randomizeBoolean() {
        return random.nextBoolean();
    }
}
