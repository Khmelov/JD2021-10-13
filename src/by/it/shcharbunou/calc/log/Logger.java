package by.it.shcharbunou.calc.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {
    public final String filename;

    private Logger() {
        PathFinder pathFinder = new PathFinder();
        filename = pathFinder.getStringPath(Logger.class, "log.txt");
    }

    private static class LoggerHolder {
        public static final Logger instance = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.instance;
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
