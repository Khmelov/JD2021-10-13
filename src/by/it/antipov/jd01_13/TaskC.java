package by.it.antipov.jd01_13;

import java.util.*;

public class TaskC {
    public static void main(String[] args) throws InterruptedException,NumberFormatException {



        readData();
    }

    static void readData () throws InterruptedException,NumberFormatException{
        Scanner scanner = new Scanner(System.in);
        int i=0;
        Deque<Double> numbers = new ArrayDeque<>();

        while ( i<6) {
            String stringNumber = scanner.next();
            try {
                double number = Double.parseDouble(stringNumber);
                numbers.addFirst(number);

            } catch (NumberFormatException e) {
                if (i==5){throw e;}else {Thread.sleep(100);
                    Double[] doubleNumbers = new Double[numbers.size()];
                    numbers.toArray(doubleNumbers);
                    for (int j = 0; j < doubleNumbers.length; j++) {
                        System.out.print(doubleNumbers[j] + " ");
                    }
                    i++;}
            }
        }

                }

    }

