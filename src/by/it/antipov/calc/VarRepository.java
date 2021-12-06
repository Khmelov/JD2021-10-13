package by.it.antipov.calc;

import java.util.HashMap;
import java.util.Map;

public class VarRepository {
   static Map<String,Var>  savedVars=  new HashMap<>() ;
  public  void  saveVar(String letter,Var var){
     savedVars.put(letter,var);
  }
  public Var giveVar(String letter) {
      return savedVars.get(letter);
  }

}
