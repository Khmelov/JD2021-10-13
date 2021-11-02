package by.it.marukovich.jd01_06;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static final String votes = "ауоиэыяюеё" + "ауоиэыяюеё".toUpperCase(Locale.ROOT);
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (checkVotes(word)){
                System.out.println(word);
            }
        }
    }
    private static boolean checkVotes(String word){
        char firstLetter = word.charAt(0);
        char lastLetter = word.charAt(word.length()-1);
        return votes.indexOf(firstLetter)<0 && votes.indexOf(lastLetter)>=0;
    }
}
