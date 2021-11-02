package by.it.rudakova.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
       Printer printer=new Printer();
        Parser parser=new Parser();
        Scanner scanner=new Scanner(System.in);
        for(;;){
            String expression = scanner.nextLine();
            if(expression.equals("end")){
                break;
            }
            else {
                Var var = parser.calc (expression);
                printer.print(var);
            }
        }
    }
}
