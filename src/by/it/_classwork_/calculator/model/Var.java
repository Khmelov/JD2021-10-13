package by.it._classwork_.calculator.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.StringJoiner;

import static by.it._classwork_.calculator.constants.SubStrings.*;

public abstract class Var {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @NotNull
    protected StringJoiner joiner() {
        return new StringJoiner(DELIMITER, LEFT_BRACKET, RIGHT_BRACKET);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Var var = (Var) o;
        return Objects.equals(name, var.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
