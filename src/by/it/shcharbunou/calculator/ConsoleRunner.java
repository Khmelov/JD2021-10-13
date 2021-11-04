package by.it.shcharbunou.calculator;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        Scanner scanner = new Scanner(System.in);
        InputManager inputManager = new InputManager();
        String expression = inputManager.getLine();
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var answer;
        if (!expression.equals(ApplicationReservedWords.END.getApplicationReservedWord())) {
            while (!expression.equals(ApplicationReservedWords.END.getApplicationReservedWord())) {
                answer = parser.calc(expression);
                printer.print(answer);
                expression = inputManager.getLine();
            }
        }
    }
}
