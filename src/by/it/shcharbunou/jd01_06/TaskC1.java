package by.it.shcharbunou.jd01_06;

import java.util.Arrays;

public class TaskC1 {

    public static void main(String[] args) {
        String text = Poem.text;
        String[] lines = text.split("\n");
        int alignmentRate = findAlignmentRate(lines);
        alignText(lines, alignmentRate);
        printAlignedText(lines);
    }

    private static void printAlignedText(String[] lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void alignText(String[] lines, int alignmentRate) {
        for (int i = 0; i < lines.length; i++) {
            lines[i] = alignLine(lines[i], alignmentRate);
        }
    }

    private static String alignLine(String line, int alignmentRate) {
        String[] wordsArray = line.split(" ");
        int lineLength = findLineLength(wordsArray);
        int spacesCount = alignmentRate - lineLength - (wordsArray.length - 1);
        StringBuilder alignedLine = new StringBuilder();
        String[] spacesArray = new String[wordsArray.length - 1];
        Arrays.fill(spacesArray, " ");
        fillSpacesArray(spacesArray, spacesCount);
        for (int i = 0; i < wordsArray.length; i++) {
            alignedLine.append(wordsArray[i]);
            if (i != wordsArray.length - 1) {
                alignedLine.append(spacesArray[i]);
            }
        }
        return alignedLine.toString();
    }

    private static void fillSpacesArray(String[] spacesArray, int spacesCount) {
        int i = 0;
        while (i < spacesArray.length && spacesCount > 0) {
            spacesArray[i] += " ";
            spacesCount--;
            if (i == spacesArray.length - 1) {
                i = 0;
            } else {
                i++;
            }
        }
    }

    private static int findLineLength(String[] wordsArray) {
        int length = 0;
        for (String word : wordsArray) {
            length += word.length();
        }
        return length;
    }

    private static int findAlignmentRate(String[] lines) {
        int maxLineSize = Integer.MIN_VALUE;
        for (String line : lines) {
            if (maxLineSize < line.length()) {
                maxLineSize = line.length();
            }
        }
        return maxLineSize;
    }
}
