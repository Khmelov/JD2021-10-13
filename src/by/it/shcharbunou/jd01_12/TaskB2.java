package by.it.shcharbunou.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> peoplesArrayList = new ArrayList<>();
        LinkedList<String> peoplesLinkedList = new LinkedList<>();
        int n = inputNumber();
        fillList(peoplesArrayList, n);
        fillList(peoplesLinkedList, n);
        String nameArrayList = process(peoplesArrayList);
        String nameLinkedList = process(peoplesLinkedList);
        printAnswer(nameArrayList, nameLinkedList);
    }

    private static void printAnswer(String nameArrayList, String nameLinkedList) {
        System.out.println(nameArrayList);
        System.out.println(nameLinkedList);
    }

    private static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        int counter = 0;
        while (peoples.size() > 1) {
            if (iterator.hasNext()) {
                counter++;
                iterator.next();
                if (counter == 2) {
                    iterator.remove();
                    counter = 0;
                }
            } else {
                iterator = peoples.iterator();
            }
        }
        return peoples.get(0);
    }

    private static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        int counter = 0;
        while (peoples.size() > 1) {
            if (iterator.hasNext()) {
                counter++;
                iterator.next();
                if (counter == 2) {
                    iterator.remove();
                    counter = 0;
                }
            } else {
                iterator = peoples.iterator();
            }
        }
         return peoples.get(0);
    }

    private static void fillList(List<String> peoples, int count) {
        for (int i = 0; i < count; i++) {
            peoples.add("n" + (i + 1));
        }
    }

    private static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect;
        int value = 0;
        do {
            isCorrect = true;
            try {
                value = Integer.parseInt(scanner.next());
                if (value < 1) {
                    System.err.println("Error: Value must be positive! Try again.");
                    isCorrect = false;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Value must be integer type! Try again.");
                isCorrect = false;
            }
        } while (!isCorrect);
        return value;
    }
}
