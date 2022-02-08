package by.it.shcharbunou.calc;

import java.util.HashMap;
import java.util.Map;

public class ConsoleRunner {

    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        InputManager inputManager = new InputManager();
        String expression = inputManager.getLine();
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var answer;
        Map<String, Var> variableValues = new HashMap<>();
        if (!expression.equals(ApplicationReservedWords.END.getApplicationReservedWord())) {
            while (!expression.equals(ApplicationReservedWords.END.getApplicationReservedWord())) {
                answer = parser.testCalc(expression, variableValues);
                printer.print(answer);
                expression = inputManager.getLine();
            }
        }
    }
}
