package by.it.shcharbunou.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Var implements Operation {
    @Override
    public Var add(Var other, Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("errors", locale);
        System.out.println(rb.getString("add") + " " + this + " + " + other + " " + rb.getString("impossible"));
        return null;
    }

    @Override
    public Var sub(Var other, Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("errors", locale);
        System.out.println(rb.getString("sub") + " " + this + " - " + other + " " + rb.getString("impossible"));
        return null;
    }

    @Override
    public Var mul(Var other, Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("errors", locale);
        System.out.println(rb.getString("mul") + " " + this + " * " + other + " " + rb.getString("impossible"));
        return null;
    }

    @Override
    public Var div(Var other, Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("errors", locale);
        System.out.println(rb.getString("div") + " " + this + " / " + other + " " + rb.getString("impossible"));
        return null;
    }
}
