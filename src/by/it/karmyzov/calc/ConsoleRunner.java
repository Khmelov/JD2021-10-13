package by.it.karmyzov.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scan.nextLine()).equals("end")) {
            try {
               Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcExeption e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        }
    }
}
