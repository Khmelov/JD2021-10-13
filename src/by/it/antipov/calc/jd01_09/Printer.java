package by.it.antipov.calc.jd01_09;

import java.util.Objects;

public class Printer {
    void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
        }
    }

    public void print(CalcException e) {
        System.out.println(e.getMessage());
    }
}