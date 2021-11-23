package by.it.karpovich.jd01_12;

// TaskB3. Скопируйте предыдущую задачу и измерьте на размере задачи в 4096
// элемент какой из двух методов работает быстрее. Объясните итог.
// Подумайте, как можно было бы решить задачу в методе
// process (LinkedList<String> peoples) без итератора и снижения
// быстродействия, используя интерфейсы очередей. Проверьте свою идею.

import java.util.*;

public class TaskB3 {

        public static void main(String[] args) {
            ArrayList<String> peoplesArrayList = new ArrayList<>();
            LinkedList<String> peoplesLinkedList = new LinkedList<>();
            int number = inputNumber();
            fillList(peoplesArrayList, number);
            fillList(peoplesLinkedList, number);
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
                peoples.add("add" + (i + 1));
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
                        System.err.println("value < 1");
                        isCorrect = false;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Чет не понятное");
                    isCorrect = false;
                }
            } while (!isCorrect);
            return value;
        }
    }