package by.it._classwork_.calculator;

import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.Parser;
import by.it._classwork_.calculator.services.exceptions.CalcException;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Parser parser = new Parser(null);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (!line.equals("end")) {
                try {
                    Var result = parser.calc(line);
                    System.out.println(result);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                break;
            }
        }
    }
}
