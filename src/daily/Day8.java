package daily;

import model.Day8.Kruskal;
import util.FileReader;

import java.util.List;

public class Day8 implements IDay{

    @Override
    public void displayResult() {

        List<String> data = FileReader.readDataAsListString("junctionBox");
        
        Kruskal kruskal = new Kruskal(data);
        
        int result = kruskal.computeKruskal(1000);

        System.out.println("The result computed for the last three junction box after 1000 connexions is " + result);
        
    }
}
