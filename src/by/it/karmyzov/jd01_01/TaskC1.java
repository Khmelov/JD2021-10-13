package by.it.karmyzov.jd01_01;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {

    public static void main(String[] args) {
        int[] ar = {111, 2, 3, 4, 5, 6, 7, 8, 10};
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }

        int i = 0, arLength = ar.length;
        while (i < arLength) {
            int element = ar[i];
            System.out.println(element);
            i++;
        }
    }


}
