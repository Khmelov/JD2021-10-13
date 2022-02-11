package by.it.rudakova.finaltask;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int [] randomArray=new int[10];
        for(int i=0;i<randomArray.length;i++){
            randomArray[i]=(int)(Math.random()*601)-300;
        }
        System.out.println("Сгенерированный рандомный массив из чисел от -300 до 300 ");
        for(int element:randomArray){
            System.out.print(element+" ");
        }
        System.out.println();

        Arrays.sort(randomArray);
        System.out.println("Отсортированный массив по возрастанию ");
        for(int element:randomArray){
            System.out.print(element+" ");
        }
        System.out.println();

        System.out.println("Минимальный элемент массива "+randomArray[0]);
        System.out.println("Минимальный элемент массива "+randomArray[randomArray.length-1]);

        randomArray[randomArray.length-1]=randomArray[randomArray.length-1]*randomArray[0];

        System.out.println("Замена максимального элемента");
        for(int element:randomArray){
            System.out.print(element+" ");
        }
    }
}
