package by.it.shcharbunou.calc;

import java.util.Objects;

public class Printer {

    protected void print(Var variable) {
        if (Objects.nonNull(variable)) {
            System.out.println(variable);
        }
    }
}
