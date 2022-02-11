package by.it.karpovich.jd01_05;

public class InOut {

    public static double[] getArray(String line) {

        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);

        }
        return res;

    }

    public static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + "");
        }
        System.out.println();
    }

    public static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {

            System.out.printf("%s[% -3d]=%10.1f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arr.length) {
                System.out.println();
            }
        }
    }

}
