package by.it.ena.jd01_06;
//Вывести через \n все предложения текста в порядке возрастания количества символо
//
// (!) в каждом из них. В предложениях нужно сначала заменить все небуквенные символы и их
// последовательности на один пробел и выполнить trim() для каждого предложения.

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder= new StringBuilder(Poem.text);//Pattern.compile("[!,?.:-]").matcher(Poem.text).replaceAll(" ".trim()));

    }
}
