package by.it.shcharbunou.jd02_01.multithreaded_store.utils;

import by.it.shcharbunou.jd02_01.multithreaded_store.exceptions.SuspenderException;

import java.util.concurrent.TimeUnit;

public class Suspender {

    public Suspender() {
    }

    public void suspend(int time) {
        try {
            Thread.sleep(TimeUnit.MILLISECONDS.toMillis(time));
        } catch (InterruptedException e) {
            throw new SuspenderException("Error: Thread interrupted.", e);
        }
    }
}
