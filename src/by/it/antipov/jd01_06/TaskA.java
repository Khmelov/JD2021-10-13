package by.it.antipov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void main(String[] args) {
        StringBuilder text1 = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("а-яА-ЯёЁ");
        Matcher match = pattern.matcher(text1);


    }
}
