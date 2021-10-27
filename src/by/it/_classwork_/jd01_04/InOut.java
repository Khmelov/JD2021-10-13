package by.it._classwork_.jd01_04;

public class InOut {

    static double[] getArray(String line) {
        // " 12 34 5 6 78 90 "
        line = line.trim(); // "12.1 34 5 6 78 90"
        String[] strings = line.split(" ");
        int sizeResult = strings.length;
        double[] values = new double[sizeResult];
        for (int i = 0; i < strings.length; i++) {
            values[i] = Double.parseDouble(strings[i]);
        }
        return values;
    }

    static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String arrayName, int countColumns) {
        // V[ 0 ]=-12.345   V[ 1 ]=123.1
        for (int i = 0; i < array.length; ) {
            System.out.printf("%s[% -3d]=%-9.4f ", arrayName, i, array[i]);
            i++;
            if (i % countColumns == 0 || array.length == i) {
                System.out.println();
            }
        }

    }
}
