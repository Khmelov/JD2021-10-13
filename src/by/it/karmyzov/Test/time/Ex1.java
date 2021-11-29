package by.it.karmyzov.Test.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Ex1 {

    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(2021, Month.JULY, 1);
        LocalDateTime ldt = LocalDateTime.of(2021, Month.JULY, 1, 16, 40, 9);
        LocalTime lt = LocalTime.of(16, 40);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date1 = LocalDate.parse("01 02 2015", f);
        System.out.println(date1);

//        System.out.println(ldt);
//        System.out.println(ldt.format(f));

    }
}