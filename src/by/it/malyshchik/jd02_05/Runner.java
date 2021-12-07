package by.it.malyshchik.jd02_05;

import by.it.malyshchik.jd02_05.resources.Message;
import by.it.malyshchik.jd02_05.resources.User;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Date localDate = new Date();
        String language = null;
        String country = null;
        ResourceManager lang = ResourceManager.INSTANCE;
        switch (sc.nextLine()) {
            case "ru":
                language = "ru";
                country = "RU";
                break;
            case "be":
                language = "be";
                country = "BY";
                break;

            case "en":
                language = "en";
                country = "US";
                break;

            default:

                if (args.length == 2) {
                    Locale locale = new Locale(args[0], args[1]);
                    lang.setLocal(locale);
                }
        }
        lang.setLocal(new Locale(language, country));
        DateFormat dateF = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(language, country));
        System.out.println(lang.get(Message.WELCOME));
        System.out.println(lang.get(Message.ABOUT));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(lang.get(Message.QUESTION));
        System.out.println(dateF.format(localDate));
    }
}
