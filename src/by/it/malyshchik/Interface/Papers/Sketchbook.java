package by.it.malyshchik.Interface.Papers;
public class Sketchbook extends Notebook {

    public Sketchbook(String name, double density, int listAmount){
        super(name, density, listAmount);
    }

    @Override
    public void paint() {
        System.out.println(this.getName() + " draw by pen");

    }
    @Override
    void cover() {
        System.out.println(this.getName() + " has red cover");
    }
    @Override
    public String toString(){
        return String.format("Sketchbook %s", this.getName());


        }
    }

