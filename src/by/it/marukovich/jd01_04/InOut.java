package by.it.marukovich.jd01_04;

class InOut {
    static double[] getArray(String line) {
        line = line.trim();
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
            System.out.println(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String arrayName, int countColumns) {
        for (int i = 0; i < array.length; ) {
            System.out.printf("%s[% -3d]=%-9.4f", arrayName, i, array[i]);
            i++;
            if (i % countColumns == 0 || array.length == 1) {
                System.out.println();
            }
        }
    }
    public static void matrixPrint2D(double[][] matrix, String name ){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf(name + "[%1d,%1d]=%-6.1f ", i, j, matrix[i][j]);
                System.out.println();
            }
        }
    }
}
