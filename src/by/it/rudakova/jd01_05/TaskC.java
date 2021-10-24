package by.it.rudakova.jd01_05;

import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        int arrayLength= (int) (Math.random() * 21) + 20;
        double[] array=new double[arrayLength];
        fillArray(array);
        printArray(array);
        int counter=findValue(array);
        double[] myNewArray=new double[counter];
        formNewArray(myNewArray, array);
        System.out.println();
        System.out.println();
        printArray(myNewArray);
        System.out.println();
        System.out.println();
        double geometricMean=findGeometricMean(myNewArray);
        System.out.println("Среднее геометрическое: "+geometricMean);

    }

    private static double getValue(double x) {
        double z = cbrt(pow(x, 2) + 4.5);
        return z;
    }

    private static double[] fillArray(double[] myArray) {
        double start = 5.33;
        double finish = 9;
        double distance = finish - start;
        double delta = distance / myArray.length;
        double x = start;
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = getValue(x);
            x = x + delta;
        }
        return myArray;
    }
    private static void printArray(double[] array){
        for (int i=0;i<array.length;i++){
            System.out.printf("Array[%d]=%g\t",i,array[i]);
            if((i+1)%5==0){
                System.out.println();
            }
        }
    }

    private static int findValue(double[] array){
        double value=3.5;
        int counter=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>value){
                counter++;
            }
        }
        return counter;
    }
    private static void formNewArray(double[] newArray,double [] oldArray){
        int k=0;
        for(int i=0;i<oldArray.length;i++){
            if(oldArray[i]>3.5){
                newArray[k]=oldArray[i];
                k++;
            }
        }
    }
    private static double findGeometricMean(double [] array){
        double sum=0;
        double geometric;
        for (int i=0;i<array.length;i++){
            sum=sum+1/array[i];
        }
        geometric= array.length/sum;
        return geometric;
    }
}
