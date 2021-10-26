package by.it.antipov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text1 = new StringBuilder(Poem.text);
        Pattern pattern1 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher match1 = pattern1.matcher(text1);
        while (match1.find()) {
            if (checker(match1.group())) {System.out.println(match1.group());}
        }

    }

    static boolean checker(String word) {
        return (word.charAt(0) != ('а' & 'о' & 'э' & 'е' & 'и' & 'ы' & 'у' & 'ё' & 'ю' & 'я')) & (word.charAt(word.length()-1) == ('я' | 'а' | 'о' | 'э' | 'е' | 'и' | 'ы' | 'у' | 'ё' | 'ю'));
    }
}
