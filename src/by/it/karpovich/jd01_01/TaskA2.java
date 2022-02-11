package by.it.karpovich.jd01_01;

/*
напишите тело main программы которая выводит на экран 5 строк
"Я начинаю изучать Java!"

Для ручной проверки запустите программу Ctrl+Shift+F10
Для автоматической проверки откройте и запустите класс Test_jd01_01
*/

class TaskA2 {
    public static void main(String[] args) {
        /*    System.out.println("Я начинаю изучать Java!");
        System.out.println("Я начинаю изучать Java!");
        System.out.println("Я начинаю изучать Java!");
        System.out.println("Я начинаю изучать Java!"); */
        //_________________________________________________
       /* for (int i = 1; i < 6; i++) {
        System.out.println("Я начинаю изучать Java!");
        } */
        //______________________________________________
        int i = 1;
        while (true) {
            System.out.println("Я начинаю изучать Java!");
            if (i >= 5) {
                break;
            }
            i++;
        }
    }
}
