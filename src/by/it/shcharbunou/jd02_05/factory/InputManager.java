package by.it.shcharbunou.jd02_05.factory;

import java.util.Scanner;

public class InputManager {
    public String inputLanguage() {
        String language = "";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("en/be/ru");
            language = scanner.nextLine();
        } while (!(language.equals("en") || language.equals("ru") || language.equals("be") || language.equals("")));
        return language;
    }
}
