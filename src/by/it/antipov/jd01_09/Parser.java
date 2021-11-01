package by.it.antipov.jd01_09;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Patterns {
    Var calc(String expression) {
        expression = expression.trim().replaceAll(" ", "");
        String[] stringVars = expression.split(Patterns.OPERATION, 2);
        Var left = VarCreator.createVar(stringVars[0]);
        if (Objects.isNull(left)) {
            System.out.println("Incorrect variable" + left);
            return left;
        }
        if (stringVars.length == 1) {
            return left;
        }
        Var right = VarCreator.createVar(stringVars[1]);
        if (Objects.isNull(right)) {
            System.out.println("Incorrect variable " + right);
            return right;
        }
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            switch (matcher.group()){
                case "+" :
                   return left.add(right);
                    case "-" :
                        return left.sub(right);
                    case "*" :
                        return  left.mul(right);
                    case "/" :
                        return   left.div(right);
            }
        }
        return null;
    }
}