package by.it.shcharbunou.calc;

import by.it.shcharbunou.calc.log.Logger;
import by.it.shcharbunou.calc.log.Report;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ConsoleRunner {

    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        Logger logger = Logger.getInstance();
        InputManager inputManager = new InputManager();
        String expression = inputManager.getLine();
        Parser parser = new Parser();
        Printer printer = new Printer();
        LocaleManager localeManager = new LocaleManager();
        Locale locale = Locale.getDefault();
        Var answer;
        Map<String, Var> variableValues = new HashMap<>();
        Report report = new Report.Builder()
                .withHeader("REPORT")
                .withStartTime(LocalDateTime.now())
                .withOperationsAndResults(new ArrayList<>())
                .build();
        if (!expression.equals(ApplicationReservedWords.END.getApplicationReservedWord())) {
            while (!expression.equals(ApplicationReservedWords.END.getApplicationReservedWord())) {
                if (localeManager.localeCondition(expression)) {
                    locale = localeManager.changeLocale(expression);
                }
                answer = parser.testCalc(expression, variableValues, locale, report);
                printer.print(answer, report);
                expression = inputManager.getLine();
            }
        }
        report.setEndTime(LocalDateTime.now());
        logger.log(report.toString());
    }
}
