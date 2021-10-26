package by.it.karmyzov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {Step1();}
    private static void Step1() {
        String text = Poem.text;
        String [] wordArray = text.split("[\\s,.:!?]+");
        Pattern pattern = Pattern.compile("\\b[цкнгшщзхъждлрпвфчсмтб][а-яА-яёЁ]*[йуеэоаыяию]\\b");
        for (String word : wordArray) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                System.out.println(word);
            }
        }
    }
}

