package by.it.karmyzov.calc;

interface Operation {
    Var add(Var other) throws CalcExeption;

    Var sub(Var other) throws CalcExeption;

    Var mul(Var other) throws CalcExeption;

    Var div(Var other) throws CalcExeption;
}