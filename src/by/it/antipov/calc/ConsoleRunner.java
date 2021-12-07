package by.it.antipov.calc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ConsoleRunner {

    public  static final String END = "end";
    public static void main(String[] args) {
        Date moment1= new Date();
        ArrayList <String> oper= new ArrayList<>();
        ArrayList <String> resultsS= new ArrayList<>();
        Parser parser = new Parser();
        ConstructorOfReport constructor= new ConstructorOfReport();
        BuilderS builderS = new BuilderS();
        Printer printer = Printer.printerGetter(); // Задание С, "On Demand Holder idiom"
        Logger logger = Logger.LOGGER; // Задание B,на основе Enum
    Scanner scanner = new Scanner(System.in);
        for( ; ;){String expression =scanner.nextLine();
            oper.add(expression);
       if (!expression.equals(END)) {
           Var var = null;
           try {
              expression=parser.calcInBrackets(expression);
               var = parser.calcAll(expression);
               resultsS.add(Parser.getStringOfVar(var));
           } catch (CalcException e) {
               logger.log(e);
               resultsS.add(String.valueOf(e));
               printer.print(e);
           }
           printer.print(var);
       }
       else break;
        }
constructor.setReportsBuilder(builderS);
        System.out.println("Application closed");
        Date moment2= new Date();
 constructor.constructReport("small",moment1,moment2,oper,resultsS);
        try {
            constructor.getReportsBuilder().recordInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
