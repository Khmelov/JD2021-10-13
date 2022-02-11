package by.it.karpovich.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {


    public static final String APP_CMD_STOP = "end";

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals(APP_CMD_STOP)) {
                Var var = parser.calc(expression);
                printer.print(var);
            } else {
                break;
            }

        }
        System.out.println("_____________________________");
        System.out.println("\t Application closed!");
        System.out.println("_____________________________");
    }
}
