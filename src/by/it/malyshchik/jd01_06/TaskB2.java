package by.it.malyshchik.jd01_06;

import static java.util.Arrays.sort;

//В предложениях нужно сначала заменить все небуквенные символы и их
//        последовательности на один пробел и выполнить trim() для каждого предложения.
public class TaskB2 {


            public static void main (String[]args){
                String poem = Poem.text;
                poem = poem.replace("...", " ");
                poem = poem.replace("-", " ");
                poem = poem.replace(",", " ");
                poem = poem.replace(":", " ");
                poem = poem.replace("!", ".");
                System.out.println(poem);
                String[] sentences = poem.split("[.]");
                for (int i = 0; i < sentences.length; i++) {
                    sentences[i] = sentences[i].trim();
//                for (String sentence : sentences){
//                    System.out.println(sentence.trim());
                }

            }
//Вывести через \n все предложения текста в порядке возрастания количества символов
//        (!) в каждом из них
    }



