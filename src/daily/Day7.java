package daily;

import model.Day7.QuantumTachyonDiagram;
import model.Day7.TachyonDiagram;
import util.FileReader;

import java.util.List;

public class Day7 implements IDay{
    
    @Override
    public void displayResult() {
        
        List<String> data = FileReader.readDataAsListString("manifolds");
        
        TachyonDiagram tachyonDiagram = new TachyonDiagram(data);
        
        tachyonDiagram.navigateThrough();

        System.out.println("The beam has been split " + tachyonDiagram.getCount() + " times");

        QuantumTachyonDiagram quantumTachyonDiagram = new QuantumTachyonDiagram(data);

        System.out.println("There is " + quantumTachyonDiagram.getPathCount(1, quantumTachyonDiagram.getStart()) + " possible paths");
    }
}
