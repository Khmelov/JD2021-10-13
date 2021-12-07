package by.it.ena.jd02_05.resources;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTime {
    public static String getDateTime() {

        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("be", "BY"));
        return dateFormat.format(new Date());
    }
}
