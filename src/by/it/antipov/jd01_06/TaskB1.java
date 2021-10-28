package by.it.antipov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text1 = new StringBuilder(Poem.text);
        Pattern pattern1 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher match1 = pattern1.matcher(text1);
        while (match1.find()) {
            if ((checker1(match1.group()))&(checker2(match1.group()))) {System.out.println(match1.group());}
        }

    }

    static boolean checker1(String word) {
       switch (word.charAt(0)) {
           case 'а':
           case 'о':
           case 'у':
           case 'э':
           case 'ы':
           case 'я':
           case 'ё':
           case 'е':
           case 'ю':
           case 'и':
           case 'А':
           case 'О':
           case 'У':
           case 'Э':
           case 'Ы':
           case 'Я':
           case 'Ë':
           case 'Е':
           case 'Ю':
           case 'И':
               return false;
           default:
       return true;}
    }
    static boolean checker2 (String word) {
        switch (word.charAt(word.length()-1)) {
            case 'а':
            case 'о':
            case 'у':
            case 'э':
            case 'ы':
            case 'я':
            case 'ё':
            case 'е':
            case 'ю':
            case 'и':
            case 'А':
            case 'О':
            case 'У':
            case 'Э':
            case 'Ы':
            case 'Я':
            case 'Ë':
            case 'Е':
            case 'Ю':
            case 'И':
                return true;
            default:
                return false;}

    }
}
