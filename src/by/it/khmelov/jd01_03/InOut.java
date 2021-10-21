package by.it.khmelov.jd01_03;

class InOut {


    static double[] getArray(String line) {
        //" 1 2 44 66 88 91    "
        line = line.trim();
        String[] stringValues = line.split(" ");
        double[] doubleValues = new double[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            doubleValues[i] = Double.parseDouble(stringValues[i]);
        }
        return doubleValues;
    }

    static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] array, String name, int countColumn) {
        for (int i = 0; i < array.length; i++) {
            //A[ 4 ]=-12.456   |
            System.out.printf("%s[%- 3d]=%-10.4f ", name, i, array[i]);
            if ((i+1)%countColumn==0 || i==array.length-1){
                System.out.println();
            }
        }

    }
}
