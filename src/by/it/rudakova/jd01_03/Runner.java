package by.it.rudakova.jd01_03;

import java.util.Scanner;
import java.util.SortedMap;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner scanner=new Scanner(System.in);
        String inputLine=scanner.nextLine();
       double [] doubleArray=InOut.getArray(inputLine);

        System.out.println("Вывод массива со значениями типа double:");
       InOut.printArray(doubleArray);

        System.out.println("Вывод значений элементов массива: ");
       InOut.printArray(doubleArray,"элемент массива",4);

        double minValue=Helper.findMin(doubleArray);
        System.out.println("Минимальное значение в массиве: "+minValue);
        double maxValue=Helper.findMax(doubleArray);
        System.out.println("Максимальное значение в массиве: "+maxValue);

        System.out.println("Отсортированный массив по возрастанию:");
        Helper.sort(doubleArray);

        System.out.println();


        double[][] matrixArray={{2,3,4},{7,8,9}};
        double[] vector={2,3,2};

        System.out.println("Результат умножения матрицы на вектор: ");
        double[] multipliedMatrixOnVector=Helper.multiply(matrixArray,vector);

        double[][] matrixLeft={{9,8,7},{1,2,3},{10,11,12}};
        double[][] matrixRight={{1,2},{3,4},{5,6}};

        System.out.println();

        System.out.println("Результат умножения матрицы на матрицу");
        double[][] multipliedMatrixOnMatrix=Helper.multiply(matrixLeft,matrixRight);



    }

}
