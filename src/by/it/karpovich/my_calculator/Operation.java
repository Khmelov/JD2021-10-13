package by.it.karpovich.my_calculator;

import by.it.karpovich.jd01_08.Var;

interface Operation {

    by.it.karpovich.jd01_08.Var add(by.it.karpovich.jd01_08.Var other);

    by.it.karpovich.jd01_08.Var sub(by.it.karpovich.jd01_08.Var other);

    by.it.karpovich.jd01_08.Var mul(by.it.karpovich.jd01_08.Var other);

    by.it.karpovich.jd01_08.Var div(Var other);
}
