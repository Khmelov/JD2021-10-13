package by.it.rudakova.jd02_06;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {

    private final String fileName;
    private static volatile Logger logger;

    private Logger() {
        PathFinder pathFinder = new PathFinder();
        fileName = pathFinder.getStringPath(Logger.class, "log.txt");

    }

    public static Logger getInstance() {
        Logger localLogger = Logger.logger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = Logger.logger;
                if (localLogger == null) {
                    localLogger = new Logger();
                    logger = localLogger;

                }
            }
        }
        return logger;

    }

    public void log(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true))) {
            LocalDateTime now = LocalDateTime.now();
            printWriter.printf("%s: %s%n", now, message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
