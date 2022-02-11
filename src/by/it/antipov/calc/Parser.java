package by.it.antipov.calc;

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
VarRepository saver = new VarRepository();

    Var calcAll(String expression) throws CalcException {
        Pattern pattern1 = Pattern.compile("(?<=[a-zA-Z0-9}])[-/+=*]");
        Matcher matcher1 = pattern1.matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcher1.find()) {operations.add(matcher1.group());}
        List<String> vars = new ArrayList<>(List.of(expression.split("(?<=[a-zA-Z0-9}])[-/+=*]")));
        Var result = null;
            for (int i = 2; i >= 0; i--) {
                Iterator <String> iterator = operations.iterator();
                int k=0;
                while (iterator.hasNext()){
                    String currentOper=iterator.next();
                    if (priorities.get(currentOper) == i){
                        if (Objects.isNull(vars.get(k))){throw new CalcException("There is no such variable");}
                        Var newValue = calc(vars.get(k) + currentOper + vars.get(k + 1));
                        vars.remove(k);vars.remove(k);
                        String finalValue = getStringOfVar(newValue);
                        vars.add(k,finalValue);
                        result = VarCreator.createVar(finalValue);
                    }else{ if (priorities.get(currentOper) <= i)k++;}
                }
            }
        return result;
    }

    public static String getStringOfVar(Var newValue) {
        String finalValue =null;
        if (newValue instanceof Scalar){Scalar var = new Scalar((Scalar) newValue);
             finalValue =var.toString();}
        if (newValue instanceof Vector){Vector var = new Vector((Vector) newValue);
            finalValue =var.toString();}
        if (newValue instanceof Matrix){Matrix var = new Matrix((Matrix) newValue);
            finalValue =var.toString();}
        return finalValue;
    }


    Var calc(String expression) throws CalcException {
        expression = expression.trim().replaceAll(" ", "");
        String[] stringVars = expression.split("(?<=[a-zA-Z0-9}])[-/+=*]");
        Var left = VarCreator.createVar(stringVars[0]);
        Var right = VarCreator.createVar(stringVars[1]);
        if (Objects.isNull(right)) {
            throw  new CalcException("Incorrect variable " + right);
        }
        Pattern pattern = Pattern.compile("(?<=[a-zA-Z0-9}])[-/+=*]");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            switch (matcher.group()) {
                case "+":
                    if (Objects.isNull(left)) {
                        throw  new CalcException("Incorrect variable " + left);
                    }
                    return left.add(right);
                case "-":
                    if (Objects.isNull(left)) {
                        throw  new CalcException("Incorrect variable " + left);
                    }
                    return left.sub(right);
                case "*":
                    if (Objects.isNull(left)) {
                        throw  new CalcException("Incorrect variable " + left);
                    }
                    return left.mul(right);
                case "/":
                    if (Objects.isNull(left)) {
                        throw  new CalcException("Incorrect variable " + left);
                    }
                    return left.div(right);
                case "=":

                    saver.saveVar(stringVars[0], right);
                    return right;
            }
        }
        return null;
    }

  String calcInBrackets (String expression) throws CalcException {
      //String newExpression= expression;
Pattern pattern = Pattern.compile("(\\(([}{,0-9a-zA-Z-+*/.]+)\\))");
Matcher matcher = pattern.matcher(expression);
if (matcher.find()){ String firstGroup = matcher.group();
    String newGroup= firstGroup.replace("(","").replace(")","");
Var newVar = calcAll(newGroup);
expression=expression.replace(firstGroup,getStringOfVar(newVar));
 expression=calcInBrackets(expression) ;}
      return expression;
  }


}