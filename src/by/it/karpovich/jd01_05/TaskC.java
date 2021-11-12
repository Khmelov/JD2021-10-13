package by.it.karpovich.jd01_05;


import java.util.Scanner;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {
    public static final String BIN_FILE_NAME = "TEXT";
    public static final String TXT_FILE_NAME = "TEXT";

    public static void main(String[] args) {
        step6();
        step7();

    }

    private static void step6() {

        for (double x = 5.33; x <= 9; x = x + 0.099) {   // <-- наше условие
            double z = cbrt(pow(x, 2) + 4.5);
           System.out.println(z);

        }
    }

    private static void step7() {

    }

}
