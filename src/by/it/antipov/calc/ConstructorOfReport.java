package by.it.antipov.calc;

import java.util.ArrayList;
import java.util.Date;

public class ConstructorOfReport {
    ReportsBuilder reportsBuilder;

    public Report getReportsBuilder() {
        return reportsBuilder.getReport();
    }

    public void setReportsBuilder(ReportsBuilder reportsBuilder) {
        this.reportsBuilder = reportsBuilder;
    }



public void constructReport(String name,Date date1, Date date2, ArrayList<String> oper, ArrayList<String> res){
        reportsBuilder.createNewReport();
    reportsBuilder.giveRootAndName(name);
    reportsBuilder.giveOperAndRes(oper, res);
    reportsBuilder.giveTime(date1,date2);
}

}
