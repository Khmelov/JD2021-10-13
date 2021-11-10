package by.it.karmyzov.calc;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Parser {


     Var calc(String expression) throws CalcExeption {
         expression=expression.trim().replaceAll("\\s+","");
         String[] operand=expression.split(Patterns.OPERATION);
        Var two = Var.createVar(operand[1]);
        if (expression.contains("=")) {
          return Var.saveVar(operand[0],two);
        }
        Var one = Var.createVar(operand[0]);
        if (one==null || two==null)
            throw new CalcExeption ("Error");
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            String operetion= m.group();
            switch (operetion) {
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
throw new CalcExeption("Error");
    }
}
