package by.it.shcharbunou.jd02_03.multithreaded_store.utils;

public class Timer {

    public Timer() {
    }

    public boolean isRunning(long startTime, long currentTime, int workingTime) {
        return currentTime - startTime < workingTime;
    }
}
