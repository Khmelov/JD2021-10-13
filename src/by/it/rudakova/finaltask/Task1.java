package by.it.rudakova.finaltask;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random random=new Random();
        int bound=30;
        int x= random.nextInt(bound);
        int y=random.nextInt(bound);
        int z=random.nextInt(bound);

        if(x>z){
            int sum=x+y;
            System.out.println("Cумма x+y="+sum);
        }
        else{
            System.out.println("Число z="+z);
        }

        int average=(x+y+z)/3;
        System.out.println("Среднее арифметическое равно "+average);
    }
}
