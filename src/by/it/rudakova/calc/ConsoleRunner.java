package by.it.rudakova.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        VarRepository varRepository=new VarRepository();
        Parser parser = new Parser(varRepository);
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            } else {
                try {
                    Var var = parser.calc(expression);
                    printer.print(var);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Calculator is closed");
    }
}

