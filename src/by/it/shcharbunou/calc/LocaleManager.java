package by.it.shcharbunou.calc;

import java.util.Locale;

public class LocaleManager {
    public boolean localeCondition(String expression) {
        return expression.equals("ru") || expression.equals("be") || expression.equals("en");
    }

    public Locale changeLocale(String expression) {
        if (expression.equals("ru")) {
            return new Locale("ru", "RU");
        }
        if (expression.equals("en")) {
            return Locale.US;
        }
        return new Locale("be", "BY");
    }
}
