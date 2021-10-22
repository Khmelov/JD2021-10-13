package by.it.ena.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
// Вывод скорее всего неправильный, переспросить
public class TaskC {

    public static void main(String[] args) {
        System.out.println("Введите n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = step1(n);
        System.out.println(Arrays.deepToString(array));
       // for (int i = 0; i < array.length; i++) {
        //    for (int j = 0; j < array[i].length; j++) {
        //        System.out.print(array[i][j] + "\t");
         //   }
         //   System.out.println();
        //int sum=step2(array);
        int[][] matrix = step3(array);
        System.out.println(Arrays.deepToString(matrix));

    }

    public static int[][] step1(int n) {
        int[][] array = new int[n][n];
        boolean maxFound;
        boolean minFound;
        do {
            maxFound = false;
            minFound = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    Random random = new Random();
                    array[i][j] = -n + random.nextInt(n * 2 + 1);
                    if (array[i][j] == -n) {
                        minFound = true;
                    }
                    if (array[i][j] == n) {
                        maxFound = true;
                    }
                }
            }
        } while (!maxFound && !minFound);
        return array;
    }

    // public static int step2(int[][] array) {
      //  int sum=0;
     //   for (int i = 0; i < array.length ; i++) {
     //       sum=0;
         //   for (int j = 0; j < array[i].length; j++) {
        //       sum+=array[i][j];
      //      }
      //      System.out.println("Сумма элементов " + i + "-й строки: " + sum);
       // }
     //   return sum;
   // }

    static int[][] step3(int[][] array) {
        int max=Integer.MIN_VALUE;
        for (int[]row:array) {
            for (int element:row) {
                if(element>max){
                    max=element;
                }
            }
        }
        boolean[] skipCols=new boolean[array[0].length];//кол-во столбцов в строке 0
        boolean[] skipRows=new boolean[array.length];
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]==max){
                    skipCols[j]=true;
                    skipRows[i]=true;
                }
            }
        }
        int rows=0;
        for (boolean skipRow: skipRows) {
            if(!skipRow){
                rows++;
            }
        }
        int cols=0;
        for (boolean skipCol: skipCols) {
            if(!skipCol){
                cols++;
            }
        }
        int [][]out=new int[rows][cols];
        for (int i = 0, iOut=0; i < array.length ; i++) {
            if (!skipRows[i]){
                for (int j = 0, jOut=0; j < array[i].length; j++) {
                    if(!skipCols[j]){
                        out[iOut][jOut++]= array[i][j];
                    }
                }
                iOut++;
            }
        }
        return out;

}}
