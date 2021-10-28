package by.it.ena.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.ena.jd01_06.Poem.text;

public class TaskB1 {
    //Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся
    //гласной буквой

    //
//        StringBuilder stringBuilder=new StringBuilder(Poem.text);
//        char[] vowels = new char[]{'а','я','е','ё','й','у','э','о','ы','ю','и'};
//        for (String word:stringBuilder.split("\\s+")) {
//            if (vowels.contains(word.substring(0,1))) System.out.println(word);
//        }
//    }
//}

    private static String[] words = {};
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile("[ЦКНГШЩЗХЪЖДЛРПВФЧСМТЬБцкнгшщзхъждлрпвфчсмтьб][а-яА-ЯёЁ]*[уеёэоаыяиюУЕЁЭОАЫЯИЮ]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}




