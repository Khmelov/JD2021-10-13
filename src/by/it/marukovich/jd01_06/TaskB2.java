package by.it.marukovich.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text.replace("...", " ");
        String[] sentences = text.split("[!?.]");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }
        Comparator<String> comparable = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Arrays.sort(sentences, comparable);
        for (String sentence : sentences){
            System.out.println(sentence);
        }
    }
}
