package by.it.shcharbunou.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        String regex = "[а-яА-ЯёЁ]{4,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        replaceLetters(text, matcher);
        printText(text);
    }

    private static void replaceLetters(StringBuilder text, Matcher matcher) {
        while (matcher.find()) {
            int start = matcher.start();
            text.setCharAt(start + 3, '#');
            if (matcher.group().length() >= 7) {
                text.setCharAt(start + 6, '#');
            }
        }
    }

    private static void printText(StringBuilder text) {
        System.out.println(text);
    }
}
