package by.it.karpovich.jd01_14;

// В классе TaskB нужно выполнить следующие шаги:
// В файле с текстом Poem.txt нужно подсчитать общее количество знаков
//препинания и слов
// Вывести результат на консоль в виде одной строки:
//words=123, punctuation marks=15
// Продублировать вывод в консоль в файл resultTaskB.txt

import java.util.Locale;

public class TaskB {


    static final String WORD_PATTERN = "[а-яА-ЯёЁ]+";
    private static final String PUNCTUATION_PATTERN = "[-/?.!:,]+";
    public static final String TXT_FILE_NAME = "resultTaskB.txt";

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

    }
}
