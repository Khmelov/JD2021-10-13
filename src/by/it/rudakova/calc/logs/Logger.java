package by.it.rudakova.calc.logs;

import by.it.rudakova.calc.helpers.PathFinder;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private Logger(){
        syncObject = new Object();
        PathFinder pathFinder=new PathFinder();
        fileName = pathFinder.getStringPath(Logger.class,"log.txt");
    }
    public static Logger getInstance(){
        if(instance==null){
            instance=new Logger();
        }
        return instance;
    }

    private Object syncObject;
    private String fileName;

    public void log(String message){
        synchronized (syncObject) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            try (FileWriter printWriter = new FileWriter(fileName, true)) {
                printWriter.write(now.toString() + ": " +message);
                printWriter.write("\n");
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }
        }
    }
}
