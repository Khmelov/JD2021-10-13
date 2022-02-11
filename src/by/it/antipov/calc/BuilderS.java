package by.it.antipov.calc;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class BuilderS extends ReportsBuilder{

    @Override
    public void giveRootAndName(String name) {
        StringBuilder root = new StringBuilder(System.getProperty("user.dir"));
        String partTwo = Logger.class.getName().replace(".", File.separator).replace("Logger","");
        root.append(File.separator+"src"+File.separator+partTwo+name+".txt");
        report.setPath(root);
        report.setName(name);
    }



    @Override
    public void giveTime(Date date1, Date date2) {
        String informTime ="start time:"+date1.toString()+" final time:"+ date2.toString();
        report.setTime(informTime);
    }

    @Override
    public void giveOperAndRes(ArrayList<String> oper, ArrayList<String> res) {
        String operAndRes= "Operations:"+oper.toString()+" Results:"+res.toString();
        report.setOperAndRes(operAndRes);
    }


}
