package by.it.antipov.jd01_03;

import java.util.Scanner;

public class InOut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       String line = sc.nextLine();
       String value = "value";
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] left = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] right = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
       getArray(line);
        printArray(getArray(line));
        System.out.println();
       printArray(getArray(line),value,4);
        Helper.multiply(matrix,getArray(line));
        Helper.multiply(left,right);
    }

    static double[] getArray(String line) {
        line = line.trim();
        String[] strings = line.split(" ");
        double[] array = new double[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strings[i]);

        }
        return array;
    }

    static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }
    static void printArray (double[] array,String name,int columnCount){
        for (int i = 0; i < array.length; i++) {
         System.out.printf(" %1$s[%2$-1d]=%3$-4.4f",name,i,array[i]);
         if ((i+1)%columnCount==0 | i== array.length-1) {System.out.println();}
        }
    }

}
