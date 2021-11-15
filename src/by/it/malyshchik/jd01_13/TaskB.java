package by.it.malyshchik.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

//В классе TaskB напишите цикл, который:
// считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
// переводит каждую строку в вещественное число и выводит в консоль данное число и корень из суммы всех
// ранее введенных чисел, включая введенное;
// если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и показывает
// в консоли сообщение, такого же формата, как в предыдущем задании
// если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException
public class TaskB {
    private static char[] value;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        while (true) {
            String value = sc.nextLine();
            if (value.equals("END")) {
                break;
            }
            try {
                double valueDouble = Double.parseDouble(value);
                System.out.println(valueDouble);
                sum += valueDouble;
                double sqrtSum = Math.sqrt(sum);
                System.out.println(sqrtSum);
                if (sum < 0)
                    throw new ArithmeticException();
            } catch (NumberFormatException | ArithmeticException e) {
                Class<? extends Exception> exceptionType = e.getClass();
                String name = exceptionType.getName();
                Class<TaskB> nameOfClass = TaskB.class;
                String nameOfClassInStackTrace = nameOfClass.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    String className = element.getClassName();
                    if (className.equals(nameOfClassInStackTrace)) {
                        int lineNumber = element.getLineNumber();
                        System.out.printf(
                                " name: %s\n" +
                                "class: %s\n" +
                                " line: %d\n",
                                name,className,lineNumber);
                        break;
                    }
                }
            }
        }

    }
}

