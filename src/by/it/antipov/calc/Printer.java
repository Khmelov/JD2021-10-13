package by.it.antipov.calc;

import java.util.Objects;

public class Printer {

   public static class subPrinter {
       public  static final Printer printer=new Printer();
   };
   public static Printer printerGetter() {
       return subPrinter.printer;
   }
    void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
        }
    }

    public void print(CalcException e) {
        System.out.println(e.getMessage());
    }
}