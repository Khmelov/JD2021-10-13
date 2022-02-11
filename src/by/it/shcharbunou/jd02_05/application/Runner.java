package by.it.shcharbunou.jd02_05.application;

import by.it.shcharbunou.jd02_05.factory.InputManager;
import by.it.shcharbunou.jd02_05.service.LocaleService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        InputManager inputManager = new InputManager();
        LocaleService localeService = new LocaleService();
        String language = inputManager.inputLanguage();
        Locale locale = localeService.getLocale(language);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("greetings", locale);
        System.out.println(resourceBundle.getString("greetings"));
        printDate(locale);
    }

    private static void printDate(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        Date currentDate = new Date();
        String date = dateFormat.format(currentDate);
        System.out.println(date + " " + locale);
    }
}
