package by.it.antipov.calc;


public abstract class  Var implements Operation {
    @Override
  public String toString() {
        return ("unknown variable(abstract stab)");
    }

   public Var add(Var other)throws CalcException{
      throw  new CalcException(this+"+"+other+" "+"Can't be calculated");
        }

   public Var sub(Var other) throws CalcException {
       throw  new CalcException (this+"-"+other+" "+"Can't be calculated");
      }

   public Var mul(Var other) throws CalcException {throw  new CalcException(this+"*"+other+" "+"Can't be calculated");
        }

   public Var div(Var other) throws CalcException { throw  new CalcException(this+"/"+other+" "+"Can't be calculated");
    }

}
