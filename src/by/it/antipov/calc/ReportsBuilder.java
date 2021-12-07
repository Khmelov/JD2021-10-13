package by.it.antipov.calc;

import java.util.ArrayList;
import java.util.Date;

public abstract class ReportsBuilder {
Report report;

    public Report getReport() {
        return report;
    }
    void  createNewReport(){report=new Report();}
    public abstract void giveRootAndName(String name);
public abstract void giveTime(Date date1,Date date2);
public abstract void giveOperAndRes(ArrayList<String> oper,ArrayList<String> res);

}
