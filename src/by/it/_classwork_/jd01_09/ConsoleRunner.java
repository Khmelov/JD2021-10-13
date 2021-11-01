package by.it._classwork_.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {


    public static final String FINAL_APP_CMD = "end";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals(FINAL_APP_CMD)) {
                Var var = parser.calc(expression);
                printer.print(var);
            } else {
                break;
            }

        }
        System.out.println("Application closed");
    }
}
