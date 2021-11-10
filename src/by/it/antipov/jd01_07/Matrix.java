package by.it.antipov.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Matrix extends Var{
    double [][] value;

    Matrix (double[][] value){this.value=value;}
    Matrix (Matrix matrix) {this.value=matrix.value;}
    Matrix (String stringValue){
        int j=0;
        int i=0;
        Pattern pattern1 = Pattern.compile ("-?[0-9]+(\\.?[0-9]+)?");
        Matcher matcher1 = pattern1.matcher(stringValue);
        Pattern pattern2 = Pattern.compile("[\\}]");
        Matcher matcher2 = pattern2.matcher(stringValue);
        Matcher matcher3 = pattern1.matcher(stringValue);
        while (matcher2.find()) {j++;}
        j=j-1;
        System.out.println(j);
        while (matcher1.find()) {i++;}
        int k= i/j;
        System.out.println(k);
        double[][] resMatrix = new double [j][k];
        int l=k-1;
        k=0;
        j=0;
while (matcher3.find()) {resMatrix[j][k]=Double.parseDouble(matcher3.group());
    System.out.println(j+" "+k+"   "+resMatrix[j][k]);
    if(k==l){j++;k=0;}
    else if (k!=l){k++;}

}
this.value=resMatrix;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        int i=0;
        out.append("{");
        String devider1="";
        for (double []arr:value) {  out.append(devider1);devider1=", ";
            out.append("{");
            String devider="";
            for (double arr1:value[i]) {
                out.append(devider);
                out.append(arr1);
                devider=", ";


            }
            i++;
            out.append("}");}
        out.append("}");
        return out.toString();
    }
}
