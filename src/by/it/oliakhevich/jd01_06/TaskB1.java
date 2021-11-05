package by.it.oliakhevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        String text = Poem.text;
        String[] wordArray = text.split("[\\s,.!?]");//пробный не прошел
        Pattern pattern = Pattern.compile("[ЦКЕНГШЩЗХЪЖДЛРПВФЧСМТЬБцкнгшщзхъждлрпвфчсмтьб].*[уеёэоаыяиюУЕЁЭОАЫЯИЮ]");
        for (String word : wordArray){
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()){
                System.out.println(word);
            }

        }
        // System.out.println(text);


    }
}
