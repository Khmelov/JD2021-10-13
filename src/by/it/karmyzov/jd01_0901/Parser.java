package by.it.karmyzov.jd01_0901;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String exression) {
        exression = exression.trim().replace(" ", "");
        String[] parts = exression.split(Patterns.OPERATION, 2);
        String leftPart = parts[0];
        Var left = VarCreator.createVar(leftPart);
        if (Objects.isNull(left)) {
            System.out.println("Incorrect variable" + leftPart);
            return left;
        }
        if (parts.length == 1) {
            return left;
        }
        String rightPart = parts[1];
        Var right = VarCreator.createVar(rightPart);
        if (Objects.isNull(right)) {
            System.out.println("Incorrect variable" + rightPart);
            return right;
        }
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = patternOperation.matcher(exression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
            }
        }
        System.out.println("Something wrong");
        return null;
    }

}