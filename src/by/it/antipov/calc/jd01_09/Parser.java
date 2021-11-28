package by.it.antipov.calc.jd01_09;

import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Patterns {
    Map<String, Integer> priorities = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

//Parser parser= new Parser();

    Var calcAll(String expression) throws CalcException {
        Pattern pattern1 = Pattern.compile("(?<=[a-zA-Z0-9])[-/+=*]");
        Matcher matcher1 = pattern1.matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcher1.find()) {operations.add(matcher1.group());}
        List<String> scalars = new ArrayList<>(List.of(expression.split("(?<=[a-zA-Z0-9])[-/+=*]")));
        Var result = null;
            for (int i = 2; i >= 0; i--) {
                Iterator <String> iterator = operations.iterator();
                int k=0;
                while (iterator.hasNext()){
                    String currentOper=iterator.next();
                    if (priorities.get(currentOper) == i){
                        Var newValue = Parser.calc(scalars.get(k) + currentOper + scalars.get(k + 1));
                        scalars.remove(k);scalars.remove(k);Scalar scalar = new Scalar((Scalar) newValue);
                        String finalValue =scalar.toString();
                        result = VarCreator.createVar(finalValue);
                        scalars.add(k,finalValue);

                    }else{ if (priorities.get(currentOper) <= i)k++;}
                }
               /* for (int j=0;j<operations.size();j++) { //вставь сюда итерратор и через него удали
                    if (priorities.get(operations.get(j)) == i) {
                        Var newValue = Parser.calc(scalars.get(j) + operations.get(j) + scalars.get(j + 1));
scalars.remove(j);scalars.remove(j);operations.remove(j);Scalar scalar = new Scalar((Scalar) newValue);
                        String finalValue =scalar.toString();
                        result = VarCreator.createVar(finalValue);
scalars.add(j,finalValue);
                    }
                }*/
            }
        return result;
    }


    static Var calc(String expression) throws CalcException {
        expression = expression.trim().replaceAll(" ", "");
        String[] stringVars = expression.split("(?<=[a-zA-Z0-9])[-/+=*]");
        Var left = VarCreator.createVar(stringVars[0]);
        Var right = VarCreator.createVar(stringVars[1]);

        if (stringVars.length == 1) {
            return left;
        }

        if (Objects.isNull(right)) {
            System.out.println("Incorrect variable " + right);
            return right;
        }

        Pattern pattern = Pattern.compile("(?<=[a-zA-Z0-9])[-/+=*]");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            switch (matcher.group()) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
                case "=":
                    VarRepository saver = new VarRepository();
                    saver.saveVar(stringVars[0], right);
                    return right;
            }
        }
        return null;
    }
}