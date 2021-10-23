package by.it.oliakhevich.jd01_03;

public class InOut {


    static double[] getArray(String line) {
        String[] strArr = line.split(" ");
        double[] result = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            result[i] = Double.parseDouble(strArr[i]);
        }


        return result;


    }

    static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();

    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            if ((i + i) % columnCount == 0 || i + i == array.length) ;
            System.out.println();


        }
    }


}








