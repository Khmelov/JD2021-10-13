package by.it.shcharbunou.jd01_06;

public class TaskB2 {

    public static void main(String[] args) {
        String text = Poem.text;
        String clearText = removeNonLetterCharacters(text);
        String[] sentences = clearText.split("[.!?]");
        trimSentences(sentences);
        sortSentences(sentences);
        printSortedSentences(sentences);
    }

    private static void printSortedSentences(String[] sentences) {
        boolean isUnique;
        for (int i = 0; i < sentences.length; i++) {
            isUnique = true;
            for (int j = i + 1; j < sentences.length; j++) {
                if (sentences[i].length() == sentences[j].length()) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                System.out.println(sentences[i]);
            }
        }
    }

    private static void sortSentences(String[] sentences) {
        mergeSort(sentences);
    }

    private static void trimSentences(String[] sentences) {
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].trim();
        }
    }

    private static String removeNonLetterCharacters(String text) {
        String regex = "[^а-яА-ЯёЁ.!?]+";
        String secondRegex = "[а-яА-ЯёЁ ]+[.]{2,}";
        String temporaryText = text.replaceAll(regex, " ");
        return temporaryText.replaceAll(secondRegex, "");
    }

    private static void mergeSort(String[] array) {
        int arrayLength = array.length;

        if (arrayLength < 2) {
            return;
        }

        int middleIndex = arrayLength / 2;
        String[] leftPart = new String[middleIndex];
        String[] rightPart = new String[arrayLength - middleIndex];

        System.arraycopy(array, 0, leftPart, 0, middleIndex);
        System.arraycopy(array, middleIndex, rightPart, 0, arrayLength - middleIndex);

        mergeSort(leftPart);
        mergeSort(rightPart);

        mergeArrays(array, leftPart, rightPart);
    }

    private static void mergeArrays(String[] array, String[] leftPart, String[] rightPart) {
        int leftPartSize = leftPart.length;
        int rightPartSize = rightPart.length;

        int leftPartCounter = 0, rightPartCounter = 0, mergedArrayCounter = 0;

        while (leftPartCounter < leftPartSize && rightPartCounter < rightPartSize) {
            if (leftPart[leftPartCounter].length() <= rightPart[rightPartCounter].length()) {
                array[mergedArrayCounter] = leftPart[leftPartCounter];
                leftPartCounter++;
            } else {
                array[mergedArrayCounter] = rightPart[rightPartCounter];
                rightPartCounter++;
            }
            mergedArrayCounter++;
        }

        while (leftPartCounter < leftPartSize) {
            array[mergedArrayCounter] = leftPart[leftPartCounter];
            leftPartCounter++;
            mergedArrayCounter++;
        }

        while (rightPartCounter < rightPartSize) {
            array[mergedArrayCounter] = rightPart[rightPartCounter];
            rightPartCounter++;
            mergedArrayCounter++;
        }
    }
}
