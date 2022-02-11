package by.it.oliakhevich.jd01_06;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static final String voweLitters = "аеёиоуыэюя" + "аеёиоуыэюя".toUpperCase(Locale.ROOT);

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");     //регулярные выражения, описывает все слова русского языка
        Matcher matcher = pattern.matcher(Poem.text);    //перебор этих слов из Pattern
        while (matcher.find()) {
            String litters = matcher.group();
            if (checkLitters(litters)) {
                System.out.println(litters);
            }
        }
    }

    private static boolean checkLitters(String litters) {
        return voweLitters.indexOf(litters.charAt(0)) < 0 &&
                voweLitters.indexOf(litters.charAt(litters.length() - 1)) >= 0;
    }
}
