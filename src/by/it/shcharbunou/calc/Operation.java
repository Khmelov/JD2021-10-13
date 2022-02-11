package by.it.shcharbunou.calc;

import java.util.Locale;

public interface Operation {
    Var add(Var other, Locale locale);
    Var sub(Var other, Locale locale);
    Var mul(Var other, Locale locale);
    Var div(Var other, Locale locale);
}
