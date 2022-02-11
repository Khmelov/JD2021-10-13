package by.it._classwork_.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

public class TaskB2 {

    public static void main(String[] args) {
        String text = Poem.text.replace("...", " ");
        String[] sentences = text.split("[!?.]");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }
        Arrays.sort(sentences, Comparator.comparingInt(String::length));
        Arrays.sort(sentences, Comparator.comparingInt(String::length));
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
