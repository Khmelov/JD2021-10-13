package by.it.shcharbunou.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        List<Integer> elementsList = new ArrayList<>();
        fillList(elementsList);
        sortCharacters(elementsList);
        printList(elementsList);
    }

    private static void printList(List<Integer> elementsList) {
        System.out.println(elementsList);
    }

    private static void sortCharacters(List<Integer> elementsList) {
        List<Integer> positiveList = new ArrayList<>(elementsList);
        List<Integer> negativeList = new ArrayList<>(elementsList);
        List<Integer> zeroList = new ArrayList<>(elementsList);
        positiveList.removeIf(element -> element <= 0);
        negativeList.removeIf(element -> element >= 0);
        zeroList.removeIf(element -> element != 0);
        elementsList.clear();
        elementsList.addAll(positiveList);
        elementsList.addAll(zeroList);
        elementsList.addAll(negativeList);
    }

    private static void fillList(List<Integer> elementsList) {
        final String END = "end";
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect;
        String temporaryStringValue;
        boolean isEnd;
        do {
            isCorrect = true;
            temporaryStringValue = scanner.next();
            if (!temporaryStringValue.equals(END)) {
                isEnd = false;
                try {
                    elementsList.add(Integer.parseInt(temporaryStringValue));
                } catch (Exception e) {
                    System.out.println("Error: Try again.");
                    isCorrect = false;
                }
            } else {
                isEnd = true;
            }
        } while (!isCorrect || !isEnd);
    }
}
