package by.it.antipov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        int index=0;
        for (;;) {
            String line = scanner.next();
            if (!line.equals("end")) {
                int number = Integer.parseInt(line);
                if (number < 0) {
                    list.add(number);
                } else if (number > 0) {
                    list.add(index, number);
                    index++;
                } else if (number == 0) {
                    list.add(index, number);
                }
            } else break;
        }
        System.out.println(list);
    }
} // -4 3 0 0 18 2 0 0 -6 9 0
