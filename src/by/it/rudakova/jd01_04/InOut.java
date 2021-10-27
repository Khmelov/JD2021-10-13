package by.it.rudakova.jd01_04;

public class InOut {
    public static void main(String[] args) {

    }


    static double[] getArray(String line) {
        String[] stringLine = line.split(" ");

        double[] doubleArray = new double[stringLine.length];

        for (int i = 0; i < stringLine.length; i++) {
            doubleArray[i] = Double.parseDouble(stringLine[i]);

        }

        return doubleArray;
    }


    static void printArray(double[] array) {

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");

        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(" %s[% -3d]=%-2.2f", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == array.length) {
                System.out.println();
            }

        }

    }

}
