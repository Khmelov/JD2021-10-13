package by.it.marukovich.jd01_09;

import by.it._classwork_.jd01_09.Var;

import java.util.Objects;

public class Printer {

    void print(Var var) {
        if (Objects.nonNull(var)) {
            System.out.println(var);
        }
    }
}
