package by.it.shcharbunou.calc;

import by.it.shcharbunou.calc.log.Report;

import java.util.Objects;

public class Printer {

    protected void print(Var variable, Report report) {
        if (Objects.nonNull(variable)) {
            report.getOperationsAndResults().add(variable.toString());
            System.out.println(variable);
        }
    }
}
