package by.it.malyshchik.Interface.Papers;

public class Runner {
    public static void main(String[] args) {
        Notebook[] notebooks = {
                new Sketchbook("ABC", 120.0, 24),
                new Sketchbook("abc", 100.0, 48)
        };
        for(Notebook notebook : notebooks){
            notebook.cover();
            notebook.paint();
        }
    }
}
