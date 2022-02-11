package by.it.shcharbunou.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {
    private final String filename;
    private static Logger instance;

    private Logger() {
        PathFinder pathFinder = new PathFinder();
        filename = pathFinder.getStringPath(Logger.class, "log.txt");
    }

    public static Logger getInstance() {
        Logger localInstance = instance;
        if (localInstance == null) {
            synchronized (Logger.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Logger();
                }
            }
        }
        return localInstance;
    }

    public void log(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true))) {
            LocalDateTime now = LocalDateTime.now();
            printWriter.printf("%s: %s%n", now, message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
