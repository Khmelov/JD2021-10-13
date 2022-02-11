package by.it.karmyzov.calc;

import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class ConsoleRunner {

    public static final String FINAL_APP_CMD ="end";
    public static void main(String[] args) {

        Printer printer = new Printer();
        VarRepository varRepository = new VarRepository();
        Parser parser = new Parser(varRepository);
        Scanner scan = new Scanner(System.in);
        for (; ; ) {
            String expression = scan.nextLine();
            if (!expression.equals(FINAL_APP_CMD)) {
                Var var = null;
                try {
                    var = parser.calc(expression);
                    printer.print(var);


            } catch (CalcExeption e) {
                    printer.print(e);
                }
                } else {
                break;
            }
        }
        System.out.println("Aplication closed");
    }
}


