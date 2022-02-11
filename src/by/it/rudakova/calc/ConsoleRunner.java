package by.it.rudakova.calc;

import by.it.rudakova.calc.exceptions.CalcException;
import by.it.rudakova.calc.helpers.Printer;
import by.it.rudakova.calc.logs.Logger;
import by.it.rudakova.calc.repository.VarRepository;
import by.it.rudakova.calc.variables.Parser;
import by.it.rudakova.calc.variables.Var;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        VarRepository varRepository=new VarRepository();
        Parser parser = new Parser(varRepository);
        Scanner scanner = new Scanner(System.in);
        varRepository.loadFromFile();
        for (; ; ) {
            String expression = scanner.nextLine();
            Logger.getInstance().log(expression.toString());
            if(expression.equals("printvar")){
                varRepository.print();
                continue;
            }
            if (expression.equals("end")) {
                varRepository.saveToFile();
                break;
            } else {
                try {
                    Var var = parser.calc(expression);
                    printer.print(var);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    Logger.getInstance().log(e.getMessage().toString());
                }
            }
        }
        System.out.println("Calculator is closed");
        Logger.getInstance().log("Calculator is closed");
    }
}

