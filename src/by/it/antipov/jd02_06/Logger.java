package by.it.antipov.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger implements Runnable{
    private static volatile Logger logger;

    private Logger(){}
    public  static Logger getLogger(){
        Logger localLogger = Logger.logger;
        if (localLogger==null){
            synchronized (Logger.class){
                localLogger=Logger.logger;
                if (localLogger==null){
                    logger=localLogger=new Logger();
                }
            }
        }
        return logger;
    }

    public static void log()  {//synchronized (Logger.class)
    {
        try(PrintWriter fileWriter=(new PrintWriter(new FileWriter(String.valueOf(TaskA.getRoot()),true)))){LocalDateTime localDateTime=LocalDateTime.now();
            fileWriter.println("error"+"  "+localDateTime);} catch (IOException e) {
            e.printStackTrace();}
        }

    }


    @Override
    public void run() {

      log();
    }
}
