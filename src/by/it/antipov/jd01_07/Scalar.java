package by.it.antipov.jd01_07;

public class Scalar extends  Var{
double value;
    public Scalar(double value) {
        this.value=value;
    }
    public Scalar(Scalar scalar){
       this.value=scalar.value;
    }

    public Scalar (String stringValue) {
        this.value = Double.parseDouble(stringValue);
    }

    @Override
   public String toString() {
      return Double.toString(value);
    }

}
