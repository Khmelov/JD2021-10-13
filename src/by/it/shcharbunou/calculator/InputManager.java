package by.it.shcharbunou.calculator;

import java.util.Scanner;

public class InputManager {

    protected String getLine() {
        Scanner scanner = new Scanner(System.in);
        String line;
        boolean isNull;
        do {
            isNull = false;
            line = scanner.nextLine();
            if (line.equals("")) {
                isNull = true;
            }
        } while (isNull);
        return line;
    }
}
