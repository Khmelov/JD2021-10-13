package by.it.malyshchik.jd01_06;
//Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся
//гласной буквой (нужно сделать для проверки этого условия приватный метод без regex).
public class TaskB1 {
    private static String vowel = "АЕЁИОУЫЭЮЯаеёиоуыэюя";

    public static void main(String[] args) {
        String poem = Poem.text;

        for (String word : poem.split("\\s+")) {
            if (!vowel.contains(word.substring(0, 1)) && vowel.contains(word.substring(word.length() - 1)))
                System.out.println(word);
        }
    }
}
