package by.it.malyshchik.jd01_03;

import java.util.Arrays;

public class Helper {

    public static void main(String[] args) {

//        int n = 10;
//        double[] array = new double[n];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = Math.random() * 10;
//        }
        double[] array = new double[]{9.6, 2.0, 6.6};
//        findMin(array);
//        double[] array = new double[0];
        double m = findMax(array);
        double k = findMin(array);
        System.out.println(m);
        System.out.println(k);
        sort(array);
        System.out.println(Arrays.toString(array));

    }

    //    static void findMax(double[] array) {
////        array = new double[]{9.6, 2.0, 6.6};
//        double max = array[0];
//        for (double m : array) {
//            if (max < m) max = m;
//        }
//        System.out.println(max);
//    }
//}
//        if (0 == array.length) {
//            return Double.MAX_VALUE;
//        } else {
//            double max = array[0];
//            for (double m : array) {
//                if (max < m) max = m;
//            }
//            System.out.println(max);
//        }
//        return 0;
//    }
    static double findMax(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
//        System.out.println(max);
        return max;
    }

    static double findMin(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
//        System.out.println(max);
        return min;
    }

    public static void sort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            double min = array[i];
            double minElement = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minElement = j;
                }
            }
            if (i != minElement) {
                double tmp = array[i];
                array[i] = array[(int) minElement];
                array[(int) minElement] = tmp;
            }
        }
    }
}




