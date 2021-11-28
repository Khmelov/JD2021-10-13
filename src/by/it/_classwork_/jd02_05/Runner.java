package by.it._classwork_.jd02_05;

import by.it._classwork_.jd02_05.resources.Message;
import by.it._classwork_.jd02_05.resources.User;

import java.util.Locale;

public class Runner {


    public static void main(String[] args) {
        ResourceManager lang = ResourceManager.INSTANCE;
        if (args.length==2){
            Locale locale = new Locale(args[0], args[1]);
            lang.setLocal(locale);
        }
        System.out.println(lang.get(Message.WELCOME));
        System.out.println(lang.get(Message.ABOUT));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(lang.get(Message.QUESTION));
    }
}
