package by.it.karmyzov.Test;

import java.util.Scanner;

public class Еу {

    public static void main(String[] args) {
       
            int sum = 0;
            int number = 0;
            while (number <= 100) {
                if (number % 3 == 0) {
                    number++;
                    continue;
                }
                sum = sum + number;
                number++;
            }
            System.out.println(sum);
        }
    }

//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//
//            int sum = 0;
//            boolean isExit = false;
//            while (!isExit) {
//                if (scanner.hasNextInt()) {
//                    int number = scanner.nextInt();
//                    sum = sum + number;
//                } else if (scanner.hasNextLine()) {
//                    String line = scanner.nextLine();
//                    if (line.equals("ENTER")) {
//                        isExit = true;
//                    }
//                }
//            }
//            System.out.println(sum);
//        }
//    }
//
