package by.it.antipov.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Runner {


    public static void main(String[] args) {
        ResourceManager manager = ResourceManager.MANAGER;
        Scanner scanner = new Scanner(System.in);
        for (;;){String language=scanner.next();if(!Objects.equals(language, "end")){
            Locale locale=null;
            if (Objects.equals(language, "ru")){
             locale = new Locale("ru", "RU");
            manager.setLocal(locale);
        }
            if (Objects.equals(language, "be")){
             locale = new Locale("be", "BY");
            manager.setLocal(locale);
        }
            if (Objects.equals(language, "en")){
             locale = new Locale("en", "UK");
            manager.setLocal(locale);
        }
            System.out.println(manager.get("user.firstname"));
            System.out.println(manager.get("user.lastname"));
            System.out.println(manager.get("message.greetings"));
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
            Date date=new Date();
            System.out.println(dateFormat.format(date));
        }else break;}


    }
}
