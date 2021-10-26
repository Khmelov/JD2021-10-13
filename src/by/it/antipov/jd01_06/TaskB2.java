package by.it.antipov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder text1 = new StringBuilder(Poem.text);
        Pattern pattern1 = Pattern.compile("[^.!]+");
        Pattern pattern2 = Pattern.compile("[^а-яА-ЯёЁ]+");
        Pattern pattern3 = Pattern.compile("[^.!]+");
        Matcher match1 = pattern1.matcher(text1);
        Matcher match3 = pattern3.matcher(text1);
       int i=0;
        while (match1.find()) {i++;}
        System.out.println(i);
      String []sentences = new String[i];
        int f=0;
        while (match3.find()) { // два одинаковых цикла с мэтч не работают?
            System.out.println(match3.group());
            String sentence = match3.group();
            System.out.println(sentence);
            Matcher match2 = pattern2.matcher(sentence);
           String sentence1 = sentence.replace(match2.group()," ");
           String sentence2 = sentence1.trim();
            sentences[f]=sentence2;
            System.out.println(sentences[f]);
            f++;
        }
        for (int j = 0; j < sentences.length; j++) {
            if (sentences[j+1].length()<sentences[j].length()) {String buffer = sentences[j+1];
            sentences[j+1]=sentences[j];
            sentences[j]=buffer;
            }
            for (int k = 0; k < sentences.length; k++) {
                System.out.println(sentences[k]);

            }
        }
    }
}
