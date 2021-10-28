package by.it.shcharbunou.jd01_03;

public class Runner {
    public static void main(String[] args) {
        String line = InOut.getArrayLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        String arrayName = "array";
        final int COLUMNS_COUNT = 5;
        InOut.printArray(array, arrayName, COLUMNS_COUNT);
        double minValue = Helper.findMin(array);
        System.out.println("Min element: " + minValue);
        double maxValue = Helper.findMax(array);
        System.out.println("Max element: " + maxValue);
        Helper.sort(array);
        System.out.println("Sorted array:");
        InOut.printArray(array);
        InOut.printArray(array, arrayName, COLUMNS_COUNT);
        System.out.println("Enter count of rows in 1 matrix:");
        int firstMatrixRows = InOut.getNumber();
        System.out.println("Enter count of columns in 1 matrix:");
        int firstMatrixColumns = InOut.getNumber();
        System.out.println("Enter 1 matrix:");
        double[][] firstMatrix = InOut.getMatrix(firstMatrixRows, firstMatrixColumns);
        System.out.println("Enter count of rows in 2 matrix:");
        int secondMatrixRows = InOut.getNumber();
        System.out.println("Enter count of columns in 2 matrix:");
        int secondMatrixColumns = InOut.getNumber();
        System.out.println("Enter 2 matrix:");
        double[][] secondMatrix = InOut.getMatrix(secondMatrixRows, secondMatrixColumns);
        double[][] multipliedMatrix = Helper.multiply(firstMatrix, secondMatrix);
        InOut.printMatrix(multipliedMatrix);
        String vectorString = InOut.getArrayLine();
        double[] vector = InOut.getArray(vectorString);
        double[] multipliedVector = Helper.multiply(multipliedMatrix, vector);
        InOut.printArray(multipliedVector);
    }
}
