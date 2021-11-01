package by.it._classwork_.jd01_09;

import java.util.Objects;

public class Printer {

    void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
        }
    }
}
