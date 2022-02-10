package by.it.shcharbunou.calc;

import java.util.HashMap;
import java.util.Locale;
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
        LocaleManager localeManager = new LocaleManager();
        Locale locale = Locale.getDefault();
        Var answer;
        Map<String, Var> variableValues = new HashMap<>();
        if (!expression.equals(ApplicationReservedWords.END.getApplicationReservedWord())) {
            while (!expression.equals(ApplicationReservedWords.END.getApplicationReservedWord())) {
                if (localeManager.localeCondition(expression)) {
                    locale = localeManager.changeLocale(expression);
                }
                answer = parser.testCalc(expression, variableValues, locale);
                printer.print(answer);
                expression = inputManager.getLine();
            }
        }
    }
}
