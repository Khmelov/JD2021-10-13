package by.it.karpovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    //   Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся
    //  гласной буквой (нужно сделать для проверки этого условия приватный метод без regex).
    // АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя
    // аАоОэЭиИуУыЫеЕёЁюЮяЯ
    // аоэиуыеёюя

    public static final String WORD_PATTERN = "[а-яёА-ЯЁ]+";
    private static final String VOWELS_RUS = "аоэиуыеёюяАОЭИУЫЕЁЮЯ";

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            String text = matcher.group();
            if (checkWord(text)) {
                System.out.println(text);
            }
        }
    }

    private static boolean checkWord(String text) {
        boolean checkFirstLetter = VOWELS_RUS.indexOf(text.charAt(0))<0;
        boolean checkLastLetter = VOWELS_RUS.indexOf(text.charAt(text.length()-1)) >=0;
        return checkFirstLetter && checkLastLetter;
    }
}
