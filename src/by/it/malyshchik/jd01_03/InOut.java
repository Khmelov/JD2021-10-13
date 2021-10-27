package by.it.malyshchik.jd01_03;



public class InOut {
    public static double[] getArray(String line) {
        String[] strArray = line.split(" ");
        double[] res = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            res[i] = Double.parseDouble(strArray[i]);
        }
        return res;
    }

    public static void printArray(double[] array) {
        for (double element : array) {

            System.out.print(element + " ");
        }
        System.out.println();
    }
//    метод для вывода стринг массива
    public static void printStringArray(String[] array) {
    for (String element : array) {

        System.out.print(element + " ");
    }
    System.out.println();
}
    public static void printArray(double[] array, String name, int columnCount){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ",name,i,array[i]);
            if ((i+1)%columnCount==0 || i+1== array.length)
                System.out.println();

        }
    }
}
//    static double[] getArray(String line) {
//        line = line.trim();
//        String[] strings = line.split(" ");
//        int sizeResult = strings.length;
//        double[] values = new double[];
//        for (int i = 0; i < strings.length; i++) {
//            values[i] = Double.parseDouble(strings[  ])
//        }
//        return null;



