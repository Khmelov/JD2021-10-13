package by.it.rudakova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        String text=Poem.text;
        String [] wordsArray=text.split("[^а-яА-ЯёË]");

        for(int i=0;i<wordsArray.length;i++){
            boolean chars=findChars(wordsArray[i]);
            if(chars==true){
                System.out.println(wordsArray[i]);
            }
        }

    }

    private static boolean findChars(String chars) {

        if(chars == "")
        {
            return false;
        }

        if(chars.charAt(0)==chars.charAt(chars.length()-1)){
            return false;
        }
        boolean firstElement=compareChar(chars.charAt(0));
        boolean lastElement=compareChar(chars.charAt(chars.length()-1));
        if(firstElement==false&&lastElement==true){
            return true;
        }

        return false;
    }

    private static boolean compareChar(char c){
        switch (c){
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
        }
        return false;
    }
}
