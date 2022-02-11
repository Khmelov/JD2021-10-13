package by.it.karmyzov.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String expression) {
        String[] operand=expression.split(Patterns.OPERATION);
        Var one =Var.createVar(operand[0]);
        Var two =Var.createVar(operand[1]);
        if (one==null || two==null)
            return null;
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
return null;
    }
}
