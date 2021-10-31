package by.it.karmyzov.jd01_04;

public class InOut {
    static double[] getArray(String line) {

        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }

        return res;
    }

    static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            //V[1}=12.1234
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == array.length)
                System.out.println();
        }
    }
}