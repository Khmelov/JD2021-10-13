package by.it.karmyzov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();
        for (; ; ) {
            String word = sc.next();
            if (!word.equals("end")) {
                Integer i = Integer.valueOf(word);
                if (i<0) {
                    values.add(i);
                }
            } else; {

                    break;
                                        }
                }
            }
        }
