package by.it.oliakhevich.calculator.jd01_09;


import java.util.Scanner;

public class ConsoleRunner {

    public static final String END = "end";

    public static void main(String[] args) {
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals(END)) {
                Var var = parser.calc(expression);
                printer.print(var);
            } else break;
        }
        System.out.println("Application closed");
    }
}
