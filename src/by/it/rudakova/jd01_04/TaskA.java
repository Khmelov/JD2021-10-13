package by.it.rudakova.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner=new Scanner(System.in);
        String inputString=scanner.nextLine();
        buildOneDimArray(inputString);
    }

   private static void printMulTable(){
        for(int i=2;i<=9;i++){
            for(int k=2;k<=9;k++){
                System.out.printf("%1d*%1d=%-2d ",i,k,i*k);
            }
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line){

       double[] arrayFromLine= InOut.getArray(line);
       double firstValueInUnsortedArray=arrayFromLine[0];
       double lastValueInUnsortedArray=arrayFromLine[arrayFromLine.length-1];
       InOut.printArray(arrayFromLine,"V",5);
       Helper.sort(arrayFromLine);
       InOut.printArray(arrayFromLine,"V",4);
       for(int i=0;i<arrayFromLine.length;i++){
           if(firstValueInUnsortedArray==arrayFromLine[i]){
               System.out.println("Index of first element="+i);
           }
           if(lastValueInUnsortedArray==arrayFromLine[i]){
               System.out.println("Index of last element="+i);
           }
       }
    }
}
