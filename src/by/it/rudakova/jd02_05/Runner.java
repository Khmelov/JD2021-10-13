package by.it.rudakova.jd02_05;

import by.it.rudakova.jd02_05.resources.Message;
import by.it.rudakova.jd02_05.resources.User;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {

        ResourceManager lang=ResourceManager.INSTANCE;
        if(args.length==2){
            Locale locale=new Locale(args[0],args[1]);
            lang.setLocale(locale);
        }
        System.out.println(lang.get(Message.welcome));
        System.out.println(lang.get(Message.about));
        System.out.println(lang.get(User.firstname));
        System.out.println(lang.get(User.lastname));
        System.out.println(lang.get(Message.question));
    }
}
