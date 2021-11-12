package by.it.shcharbunou.jd01_12;

import java.util.Scanner;
import java.util.Stack;

public class TaskC3 {

    public static void main(String[] args) {
        String text = inputText();
        boolean isCorrectBrackets = checkBrackets(text);
        printAnswer(isCorrectBrackets);
    }

    private static void printAnswer(boolean isCorrectBrackets) {
        System.out.println(isCorrectBrackets);
    }

    private static boolean checkBrackets(String text) {
        Stack<Character> bracketsStack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '(' -> bracketsStack.push(')');
                case '[' -> bracketsStack.push(']');
                case '{' -> bracketsStack.push('}');
                case ')', ']', '}' -> {
                    if (bracketsStack.empty() || bracketsStack.peek() != text.charAt(i)) {
                        return false;
                    }
                    bracketsStack.pop();
                }
                default -> {
                }
            }
        }
        return bracketsStack.empty();
    }

    private static String inputText() {
        Scanner scanner = new Scanner(System.in);
        String temporaryText;
        boolean isCorrect;
        do {
            isCorrect = true;
            temporaryText = scanner.nextLine();
            if (temporaryText.equals("")) {
                isCorrect = false;
            }
        } while (!isCorrect);
        return temporaryText;
    }
}
