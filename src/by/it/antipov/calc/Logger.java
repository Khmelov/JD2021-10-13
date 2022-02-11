package by.it.antipov.calc;



import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public enum Logger {
    LOGGER;
    private static volatile Logger logger;



    public void log(CalcException calcException)  {
    {
        try(PrintWriter fileWriter=(new PrintWriter(new FileWriter(String.valueOf(PathFinder.getStringPath(Logger.class,"log.txt")),true)))){LocalDateTime localDateTime=LocalDateTime.now();
            fileWriter.println(calcException+"  "+localDateTime);} catch (IOException e) {
            e.printStackTrace();}
        }

    }


}
