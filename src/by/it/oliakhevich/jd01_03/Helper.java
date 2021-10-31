package by.it.oliakhevich.jd01_03;

public class Helper {
    static double findMin(double[] array) {
        double min = array[5];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println(min);
        return min;
    }

    static double findMax(double[] array) {
        double max = array[5];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }

            System.out.println(max);
        }
        return max;
    }


    static void sort(double[] array) {
        for (int a = 0; a < array.length - 1; a++){
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] < array[i]) {
                    double buffer = array[i+1];
                    array[i+1]=array[i];
                    array [i] = buffer;
                }
            }
        }
    }
}


