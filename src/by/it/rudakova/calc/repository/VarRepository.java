package by.it.rudakova.calc.repository;

import by.it._classwork_.jd01_15.RepositoryException;
import by.it.rudakova.calc.logs.Logger;
import by.it.rudakova.calc.variables.Parser;
import by.it.rudakova.calc.exceptions.CalcException;
import by.it.rudakova.calc.helpers.PathFinder;
import by.it.rudakova.calc.variables.Var;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class VarRepository {

    private final Map<String, Var> vars=new HashMap<>();

    public void save(String name, Var value){
        vars.put(name,value);
    }

    public Var load(String name){
        return vars.get(name);
    }
    public void print(){
        for(Object element:vars.keySet()){
            System.out.println(element+"="+vars.get(element));
            Logger.getInstance().log(element+"="+vars.get(element));
        }
    }

    public void saveToFile(){
        PathFinder pathFinder=new PathFinder();
        String fileName= pathFinder.getStringPath(VarRepository.class,"vars.txt");
        try(PrintWriter printWriter=new PrintWriter(fileName)){
            for(Object element:vars.keySet()){
                printWriter.println(element+"="+vars.get(element));
            }
        }catch (FileNotFoundException e){
            throw new RepositoryException(e);
        }
    }
    public void loadFromFile(){
        PathFinder pathFinder=new PathFinder();
        String fileName= pathFinder.getStringPath(VarRepository.class,"vars.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            Parser parser=new Parser(this);

            while (line != null) {
                parser.calc(line);
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }catch (FileNotFoundException e){
        }
        catch (IOException e){
            throw new RepositoryException(e);
        }
        catch (CalcException e){
            throw new RepositoryException(e);
        }
    }
}
