package by.it.antipov.jd01_02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = step1(n);
        System.out.println();
        System.out.print(step2(array));
        int [][]array1={{1,0,7,4},{1, 3, 2, 1},{7,2,3,4},{1,3,2,4}};
        System.out.println(Arrays.deepToString(step3(array)));
    }

    static int[][] step1(int n) {
        Random random = new Random();
        int[][] arr = new int[n][n];
        int max = arr[0][0];
        int min = arr[0][0];
        for (int a = 0; a < n; a++) {
            System.out.println();
            for (int b = 0; b < n; b++) {
                int value = (-n) + random.nextInt(2 * n + 1);
                arr[a][b] = value;
                if (arr[a][b] > max) {
                    max = arr[a][b];
                }
                if (arr[a][b] < min) {
                    min = arr[a][b];
                }
                System.out.print(value + " ");
            }
        }
        if ((max == n) & (min == (-n))) {
            return arr;
        } else return step1(n);
    }

    static int step2(int[][] array) {
        int n = 0;
        int wholeSum = 0;
        for (int[] element1 : array) {
            n = n + 1;
        }
        for (int a = 0; a < n; a++) {
            int i = 0;
            int sum = 0;
            for (int b = 0; b < n; b++) {
                if (array[a][b] > 0) {
                    i = i + 1;
                }
                if (i != 2 & b == n) {
                    break;
                }
                if ((i % 2 != 0) & (array[a][b] < 0)) {
                    sum = sum + array[a][b];
                }
                if (i > 2) {
                    break;
                }
            }
            wholeSum = wholeSum + sum;
        }
        System.out.println("Сумма");
        return wholeSum;
    }

    static int[][] step3(int[][] array) {
        int n = array.length;
        int max=array[0][0];
        int[] horizontal = new int[array.length];
        int[] vertical = new int[array.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j]>max) {max=array[i][j];}
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j]==max) {horizontal[j]=1; vertical[i]=1;
                }
            }
        }
    //    for (int horizontals:horizontal) {
       //     System.out.print(horizontals+",");
       // }
       // System.out.println();
       // for (int vs:vertical) {
       //     System.out.print(vs+",");
       // }

        int x=0;
        int y=0;
        for (int i = 0; i <array.length; i++) { if (vertical[i]==0){y++;} if (horizontal[i] == 0) {x++;}}
        int []finalValues = new int[x*y];
        int a=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if((horizontal[j]==0)&(vertical[i]==0)) {finalValues[a]=array[i][j];a++;}
            }
        }
        int b=0;
        int[][] finalArray = new int[y][x];
        for (int i = 0; i < y; i++) {
            System.out.println();
            for (int j = 0; j < x; j++) {
               finalArray[i][j]=finalValues[b];b++;
                System.out.print(finalArray[i][j]+" ");
            }
        }
        return finalArray;
        //System.out.println("max="+max);
    }


}
