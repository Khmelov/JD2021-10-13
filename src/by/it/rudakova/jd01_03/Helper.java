package by.it.rudakova.jd01_03;

import java.util.Scanner;

public class Helper {


    static double findMin(double[] array) {
        double minValue = 0;
        if (array.length == minValue) {
            return Integer.MIN_VALUE;
        } else {
            minValue = array[0];
            for (int i = 1; i < array.length; i++) {
                if (minValue > array[i]) {
                    minValue = array[i];
                }
            }
        }
        return minValue;
    }

    static double findMax(double[] array) {
        double maxValue = 0;
        if (array.length == maxValue) {
            return Integer.MAX_VALUE;
        } else {
            maxValue = array[0];
            for (int i = 1; i < array.length; i++) {
                if (maxValue < array[i]) {
                    maxValue = array[i];
                }
            }
        }
        return maxValue;
    }

    static void sort(double[] array) {

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    double buffer = array[j];
                    array[j] = array[j + 1];
                    array[j+1]=buffer;
                }
            }
        }

        for(double element:array){
            System.out.print(element+" ");
        }
    }

    static double[] multiply(double[][] matrix,double[] vector){
        double[] newArray=new double[matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int k=0;k< vector.length;k++){
                newArray[i]=newArray[i]+matrix[i][k]*vector[k];
            }
        }

        for(double element:newArray){
            System.out.print(element+" ");
        }
        return newArray;
    }

    static double[][] multiply(double[][] matrixLeft,double [][] matrixRight){
       double[][] multipliedMatrixOnMatrix=new double[matrixLeft.length][matrixRight[0].length];
       for(int i=0;i<matrixLeft.length;i++){
           for(int k=0;k<matrixRight[0].length;k++){
               for(int j=0;j<matrixRight.length;j++){
                   multipliedMatrixOnMatrix[i][k]=multipliedMatrixOnMatrix[i][k]+matrixLeft[i][j]*matrixRight[j][k];
               }
           }
       }

       for(int i=0;i<multipliedMatrixOnMatrix.length;i++){
           for(int k=0;k<multipliedMatrixOnMatrix[0].length;k++){
               System.out.print(multipliedMatrixOnMatrix[i][k]+" ");
           }
           System.out.println();
       }

        return multipliedMatrixOnMatrix;

    }
}

