package by.it.karpovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    //   Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся
    //  гласной буквой (нужно сделать для проверки этого условия приватный метод без regex).
    // АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя
    // аАоОэЭиИуУыЫеЕёЁюЮяЯ
    // аоэиуыеёюя

    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        String text = Poem.text;
        String[] wordArray = text.split("[\\s,.:!?]+");
        Pattern pattern = Pattern.compile("\\\\b\n[ЦКЕНГШЩЗХЪЖДЛРПВФЧСМТЬБцкнгшщзхъждлрпвфчсмтьб][а-яА-ЯёЁ]*[уеёэоаыяиюУЕЁЭОАЫЯИЮ]\\\\b");
        for (String word : wordArray) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                System.out.println(word);
            }
        }
    }


}



   /* private static void step1(){
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя]{1}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            int start = matcher.start();
            sb.setCharAt(start, '#');
            // if (matcher.group().length() >= 7) {
            //    sb.setCharAt(start, '#');
            //  }
        }
        System.out.println(sb);
    }*/