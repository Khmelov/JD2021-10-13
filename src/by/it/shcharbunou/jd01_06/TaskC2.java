package by.it.shcharbunou.jd01_06;

public class TaskC2 {

    public static void main(String[] args) {
        long millisecondsStart = System.currentTimeMillis();
        String randomText = slow(Poem.text);
        long timeSpentInMilliseconds = System.currentTimeMillis() - millisecondsStart;
        System.out.println(randomText);
        System.out.println(timeSpentInMilliseconds);
        millisecondsStart = System.currentTimeMillis();
        String fastRandomText = fast(Poem.text);
        timeSpentInMilliseconds = System.currentTimeMillis() - millisecondsStart;
        System.out.println(fastRandomText);
        System.out.println(timeSpentInMilliseconds);
    }

    private static String fast(String text) {
        String[] wordsArray = text.split("[^а-яА-ЯёЁ]+");
        int wordIndex = 0;
        StringBuilder randomText = new StringBuilder();
        final int MIN_LENGTH = 100000;
        while (randomText.length() < MIN_LENGTH) {
            randomText.append(wordsArray[wordIndex]);
            randomText.append(" ");
            if (wordIndex != wordsArray.length - 1) {
                wordIndex++;
            } else {
                wordIndex = 0;
            }
        }
        return randomText.toString();
    }

    private static String slow(String text) {
        String[] wordsArray = text.split("[^а-яА-ЯёЁ]+");
        int wordIndex = 0;
        String randomText = "";
        final int MIN_LENGTH = 100000;
        while (randomText.length() < MIN_LENGTH) {
            randomText += wordsArray[wordIndex];
            randomText += " ";
            if (wordIndex != wordsArray.length - 1) {
                wordIndex++;
            } else {
                wordIndex = 0;
            }
        }
        return randomText;
    }
}
