package by.it.karpovich.jd01_01;

import java.util.Scanner;

public class Main {
    public static void main(String... args) {

        Scanner console = new Scanner(System.in);
        System.out.println("\n Please enter your number:");
        int x = console.nextInt();
        int y = console.nextInt();
        int sum = x + y;

        // Десятичный формат числа
        System.out.println("DEC:" + x + "+" + y + "=" + sum);

        // Бинарный или двоичный формат числа
        String conv_x = Integer.toBinaryString(x);
        String conv_y = Integer.toBinaryString(y);
        String conv_sum = Integer.toBinaryString(sum);
        System.out.println("BIN:" + conv_x + "+" + conv_y + "=" + conv_sum);

        // Шеснадцатиричная форма
        String convert_x = Integer.toHexString(x);
        String convert_y = Integer.toHexString(y);
        String convert_sum = Integer.toHexString(sum);
        System.out.println("HEX:" + convert_x + "+" + convert_y + "=" + convert_sum);

        // Восьмиричная форма
        String converted_x = Integer.toOctalString(x);
        String converted_y = Integer.toOctalString(y);
        String converted_sum = Integer.toOctalString(sum);
        System.out.println("OCT:" + converted_x + "+" + converted_y + "=" + converted_sum);


    }

}
