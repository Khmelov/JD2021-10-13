package by.it.antipov.calc.jd01_09;


public abstract class Var implements Operation {
    @Override
  public String toString() {
        return ("unknown variable(abstract stab)");
    }

   public Var add(Var other){
       System.out.println(this+"+"+other+" "+"Can't be calculated");
        return null;}

   public Var sub(Var other){
       System.out.println(this+"-"+other+" "+"Can't be calculated");
       return null;}

   public Var mul(Var other){System.out.println(this+"*"+other+" "+"Can't be calculated");
        return null;}

   public Var div(Var other){ System.out.println(this+"/"+other+" "+"Can't be calculated");
       System.out.println("Can't be calculated");
       return null;}

}
