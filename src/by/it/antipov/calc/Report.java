package by.it.antipov.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Report {
    String name;
    StringBuilder path;
    String Time;
    String OperAndRes;

    public void setTime(String time) {
        Time = time;
    }

    public void setOperAndRes(String operAndRes) {
        OperAndRes = operAndRes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(StringBuilder path) {
        this.path = path;
    }

    public  void  recordInfo () throws IOException {
        File file= new File(String.valueOf(path));
       try ( FileWriter fileWriter = new FileWriter(String.valueOf(path));){
           fileWriter.write(this.toString());
       }

    }

    @Override
    public String toString() {
        return "Report " + name + '\n' +
                "Path: " + path +'\n'+
                "Time:" + Time + '\n' +
                "OperAndRes:" + OperAndRes;
    }
}
