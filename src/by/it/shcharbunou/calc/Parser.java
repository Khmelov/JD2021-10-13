package by.it.shcharbunou.calc;

import by.it.shcharbunou.calc.log.Report;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.shcharbunou.calc.Samples.*;

public class Parser {
    protected Var calc(String expression, Map<String, Var> valuesAndVariables, Locale locale, Report report) {
        String separationOperator = findMainOperator(expression);
        String[] stringOperands = splitManual(separationOperator, expression);
        if (stringOperands.length == 2) {
            Var firstOperand = VarCreator.createVar(stringOperands[0], valuesAndVariables);
            Var secondOperand = VarCreator.createVar(stringOperands[1], valuesAndVariables);
            if (!Objects.isNull(firstOperand) && !Objects.isNull(secondOperand)) {
                Pattern operationPattern = Pattern.compile(OPERATION);
                Matcher operationMatcher = operationPattern.matcher(expression);
                if (operationMatcher.find()) {
                    return switch (operationMatcher.group()) {
                        case "+" -> firstOperand.add(secondOperand, locale);
                        case "-" -> firstOperand.sub(secondOperand, locale);
                        case "*" -> firstOperand.mul(secondOperand, locale);
                        case "/" -> firstOperand.div(secondOperand, locale);
                        default -> null;
                    };
                }
            }
        }
        return null;
    }

    private String[] splitManual(String separationOperator, String expression) {
        String[] operands = new String[2];
        int firstOperandCounter = 0;
        operands[0] = "";
        operands[1] = "";
        for (int i = 0; i < expression.length(); i++) {
            if (String.valueOf(expression.charAt(i)).matches(OPERATION)) {
                firstOperandCounter++;
                break;
            }
            operands[0] += expression.charAt(i);
            firstOperandCounter++;
        }
        for (int second = firstOperandCounter; second < expression.length(); second++) {
            operands[1] += expression.charAt(second);
        }
        return operands;
    }

    private String findMainOperator(String expression) {
        String operator = "";
        for (int i = 0; i < expression.length(); i++) {
            if (String.valueOf(expression.charAt(i)).matches(OPERATION)) {
                operator = String.valueOf(expression.charAt(i));
                break;
            }
        }
        return operator;
    }

    public Var testCalc(String expression, Map<String, Var> valuesAndVariables, Locale locale, Report report) {
        report.getOperationsAndResults().add(expression);
        expression = expression.replaceAll(" ", "");
        report.getOperationsAndResults().add(expression);
        if (expression.contains("=")) {
            String variable = findVariable(expression);
            report.getOperationsAndResults().add(variable);
            String expressionOnly = findExpressionOnly(expression);
            report.getOperationsAndResults().add(expressionOnly);
            valuesAndVariables.put(variable, calcFull(expressionOnly, valuesAndVariables, locale, report));
            return valuesAndVariables.get(variable);
        } else {
            return calcFull(expression, valuesAndVariables, locale, report);
        }
    }

    private String findExpressionOnly(String expression) {
        int variableSize = 0;
        for (int i = 0; i < expression.length(); i++) {
            variableSize++;
            if (expression.charAt(i) == '=') {
                break;
            }
        }
        return expression.substring(variableSize);
    }

    private String findVariable(String expression) {
        String variable = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '=') {
                break;
            }
            variable += expression.charAt(i);
        }
        return variable;
    }

    public Var calcFull(String expression, Map<String, Var> valuesAndVariables, Locale locale, Report report) {
        Stack<String> values = new Stack<>();
        Stack<String> operations = new Stack<>();
        Map<Integer, String> valueMap = getValues(expression);
        Map<Integer, String> operationMap = getOperations(expression);
        List<String> expressionList = createExpressionList(valueMap, operationMap);
        processUnaryMinuses(expressionList);
        report.getOperationsAndResults().addAll(expressionList);
        for (int i = 0; i < expressionList.size(); i++) {
            if (valueMap.containsValue(expressionList.get(i)) || Objects.equals(expressionList.get(i), "0")) {
                values.push(expressionList.get(i));
                report.getOperationsAndResults().add(expressionList.get(i));
            } else {
                if (operations.empty()) {
                    operations.push(expressionList.get(i));
                    report.getOperationsAndResults().add(expressionList.get(i));
                } else if (Objects.equals(operations.peek(), "(")
                        || checkPriority(expressionList.get(i), operations.peek())
                        || Objects.equals(expressionList.get(i), "(")) {
                    report.getOperationsAndResults().add(expressionList.get(i));
                    operations.push(expressionList.get(i));
                } else if (Objects.equals(expressionList.get(i), ")")) {
                    while (!Objects.equals(operations.peek(), "(")) {
                        String oneOperationExpression;
                        String secondOperand = values.pop();
                        String firstOperand = values.pop();
                        String operator = operations.pop();
                        oneOperationExpression = firstOperand + operator + secondOperand;
                        report.getOperationsAndResults().add(oneOperationExpression);
                        values.push(calc(oneOperationExpression, valuesAndVariables, locale, report).toString());
                    }
                    operations.pop();
                } else if (!checkPriority(expressionList.get(i), operations.peek())) {
                    while (!checkPriority(expressionList.get(i), operations.peek())
                            && !Objects.equals(operations.peek(), "(")) {
                        String oneOperationExpression;
                        String secondOperand = values.pop();
                        String firstOperand = values.pop();
                        String operator = operations.pop();
                        oneOperationExpression = firstOperand + operator + secondOperand;
                        report.getOperationsAndResults().add(oneOperationExpression);
                        values.push(calc(oneOperationExpression, valuesAndVariables, locale, report).toString());
                        if (operations.empty()) {
                            break;
                        }
                    }
                    operations.push(expressionList.get(i));
                }
                if (i == expressionList.size() - 1) {
                    break;
                }
            }
        }
        while (!operations.empty()) {
            String oneOperationExpression;
            String secondOperand = values.pop();
            String firstOperand = values.pop();
            String operator = operations.pop();
            oneOperationExpression = firstOperand + operator + secondOperand;
            report.getOperationsAndResults().add(oneOperationExpression);
            values.push(calc(oneOperationExpression, valuesAndVariables, locale, report).toString());
        }
        return VarCreator.createVar(values.pop().replaceAll(" ", ""), valuesAndVariables);
    }

    private void processUnaryMinuses(List<String> expressionList) {
        for (int i = 0; i < expressionList.size(); i++) {
            if (i != expressionList.size() - 1) {
                if (Objects.equals(expressionList.get(i), "(") && Objects.equals(expressionList.get(i + 1), "-")) {
                    expressionList.add(i + 1, "0");
                } else if (expressionList.get(i).matches(OPERATION) && Objects.equals(expressionList.get(i + 1), "-")) {
                    expressionList.add(i + 1, "(");
                    expressionList.add(i + 2, "0");
                    for (int j = i + 4; j < expressionList.size(); j++) {
                        if (expressionList.get(j).matches(OPERATION)) {
                            expressionList.add(j, ")");
                            break;
                        }
                        if (j == expressionList.size() - 1) {
                            expressionList.add(")");
                            break;
                        }
                    }
                }
            }
        }
    }

    private List<String> createExpressionList(Map<Integer, String> values, Map<Integer, String> operations) {
        Map<Integer, String> expressionMap = new TreeMap<>();
        expressionMap.putAll(values);
        expressionMap.putAll(operations);
        return new ArrayList<>(expressionMap.values());
    }

    private boolean checkPriority(String candidate, String peeked) {
        return (candidate.equals("*") || candidate.equals("/")) && (peeked.equals("+") || peeked.equals("-"));
    }

    private Map<Integer, String> getOperations(String expression) {
        Map<Integer, String> operations = new HashMap<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '/'
                    || expression.charAt(i) == '*' || expression.charAt(i) == '(' || expression.charAt(i) == ')') {
                operations.put(i, String.valueOf(expression.charAt(i)));
            }
        }
        return operations;
    }

    private Map<Integer, String> getValues(String expression) {
        Map<Integer, String> values = new HashMap<>();
        String temporaryValue = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '/'
                    && expression.charAt(i) != '*' && expression.charAt(i) != '(' && expression.charAt(i) != ')') {
                temporaryValue += expression.charAt(i);
                if (i == expression.length() - 1 && !temporaryValue.equals("")) {
                    values.put(i, temporaryValue);
                }
            } else {
                if (!temporaryValue.equals("")) {
                    values.put(i - 1, temporaryValue);
                }
                temporaryValue = "";
            }
        }
        return values;
    }
}
